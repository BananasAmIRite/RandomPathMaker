package org.BananasAmIRite;

import org.BananasAmIRite.runnables.DrawerRunnable;

public class PathMaker {
    private final PathCanvas canvas;
    public PathMaker(PathCanvas canvas) {
        this.canvas = canvas;
    }

    public void start(int steps, int radius) {
        start(steps, radius, 1000);
    }

    public void start(int steps, int radius, int sleepTime) {
        start(steps, radius, canvas.imageWidth/2, canvas.imageHeight/2, sleepTime);
    }

    public void start(int steps, int radius, int initialX, int initialY, int sleepTime) {
        Thread thread = new Thread(new DrawerRunnable(canvas, steps, radius, initialX, initialY, sleepTime), "ParentThread"); // start a diff thread which will spawn drawer threads to draw the stuff
        thread.start();
    }

}

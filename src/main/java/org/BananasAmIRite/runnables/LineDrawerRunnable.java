package org.BananasAmIRite.runnables;

import org.BananasAmIRite.Coordinate;
import org.BananasAmIRite.PathCanvas;

public class LineDrawerRunnable implements Runnable {

    private final PathCanvas canvas;
    private final Coordinate oldPoint;
    private final Coordinate newPoint;

    public LineDrawerRunnable(PathCanvas cnv, Coordinate oldPoint, Coordinate newPoint) {
        this.canvas = cnv;
        this.oldPoint = oldPoint;
        this.newPoint = newPoint;
    }

    @Override
    public void run() {
        // were gonna ANIMATE this!


        // non-animated
        this.canvas.drawLine(oldPoint.getX(), oldPoint.getY(), newPoint.getX(), newPoint.getY());
    }
}

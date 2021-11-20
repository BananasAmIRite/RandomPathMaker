package org.BananasAmIRite.runnables;

import org.BananasAmIRite.Coordinate;
import org.BananasAmIRite.PathCanvas;
import org.BananasAmIRite.utils.Utils;

public class DrawerRunnable implements Runnable {

    private final PathCanvas canvas;
    private final int steps;
    private final int radius;
    private final Coordinate initPoint;
    private final int sleepTime;
    private Coordinate currentPoint;

    public DrawerRunnable(PathCanvas canvas, int steps, int rad, int initialX, int initialY, int sleepTime) {
        this.canvas = canvas;
        this.steps = steps;
        this.radius = rad;
        this.sleepTime = sleepTime;
        this.initPoint = new Coordinate(initialX, initialY);

        this.currentPoint = initPoint;
    }

    @Override
    public void run() {
        for (int i = 0; i < steps; i++) {
            Coordinate newPoint = randPoint(radius, currentPoint);

            Thread thread = new Thread(new LineDrawerRunnable(this.canvas, currentPoint, newPoint), "Line Drawer");
            this.currentPoint = newPoint;
            thread.start();
            try {
                thread.join();
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    private Coordinate randPoint(int radius, Coordinate point) {

        double randRadius = Math.floor(Math.random() * radius); // random radius between 0 and radius

        double maximumSumOfPoints = Math.sqrt(2*Math.pow(randRadius, 2)); // maximum sum of any point in the circle

        // determine random x change between -maxSum, +maxSum
        int xAdd = (int)Math.floor((Utils.randBool() ? 1 : -1)*(Math.floor((Math.random()*maximumSumOfPoints))));
        // get the remaining left quota of cords (maximumSumOfPoints - Math.abs(xAdd)), append a + or a - to it :D
        int yAdd = (int)Math.floor((Utils.randBool() ? 1 : -1)*(maximumSumOfPoints - Math.abs(xAdd)));
        return point.getX()+xAdd >= 0 && point.getX()+xAdd <= canvas.getWidth() && point.getY()+yAdd >= 0 && point.getY()+yAdd <= canvas.getHeight() ? new Coordinate(point.getX() + xAdd, point.getY() + yAdd) : randPoint(radius, point);
    }
}

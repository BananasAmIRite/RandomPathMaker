package org.BananasAmIRite;

public class CanvasRenderLoopThread extends Thread {
    private Canvas canvas;
    private boolean isRendering;

    public CanvasRenderLoopThread(Canvas canvas) {
        this.canvas = canvas;
    }

    public void setRendering(boolean rendering) {
        this.isRendering = rendering;
    }

    @Override
    public void run() {
        this.isRendering = true;
        while (this.isRendering) {
            canvas.repaint();
        }
    }
}

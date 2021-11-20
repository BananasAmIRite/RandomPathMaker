package org.BananasAmIRite;

import java.awt.*;

public class PathCanvas extends Canvas {
    public PathCanvas(int sizeX, int sizeY) {
        super(sizeX, sizeY);
        // init();
    }

    private void init() {
        getContext().fillRect(0, 0, imageWidth, imageHeight);
        getContext().setColor(Color.BLACK);
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        getContext().drawLine(x1, y1, x2, y2);
    }
}

package org.BananasAmIRite;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {
    protected final Image image;
    protected final int imageWidth;
    protected final int imageHeight;

    public Canvas(int sizeX, int sizeY) {
        super();
        imageWidth = sizeX;
        imageHeight = sizeY;
        image = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);

        Thread t = new CanvasRenderLoopThread(this);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, this.getX(), this.getY(), null);
    }

    public Graphics getContext() {
        return image.getGraphics();
    }
}

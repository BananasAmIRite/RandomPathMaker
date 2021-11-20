package org.BananasAmIRite;

import javax.swing.*;
import java.awt.*;

public class RandomPathMaker {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
//        GridBagLayout gbl = new GridBagLayout();

        frame.setSize(new Dimension(600, 500));
//        frame.setLayout(gbl);
//        gbl.layoutContainer(frame);

//        GridBagConstraints gbc = new GridBagConstraints();

        // gbc.fill = GridBagConstraints.BOTH;

        PathCanvas cnv = new PathCanvas(600, 500);

        // cnv.getContext().drawLine(0, 0, 10, 10);
//
//        gbl.addLayoutComponent(cnv, gbc);

        frame.add(cnv);
        // frame.pack();

        frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        PathMaker pathMaker = new PathMaker(cnv);

        pathMaker.start(100, 40, 500);

    }
}

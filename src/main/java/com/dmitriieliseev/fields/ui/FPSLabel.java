package com.dmitriieliseev.fields.ui;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class FPSLabel {
    private long lastSecond = System.currentTimeMillis();
    private int fps = 0;
    private int frames = 0;

    public void paint(final Graphics g) {
        frames++;
        if (System.currentTimeMillis() - lastSecond > 1000) {
            fps = frames;
            frames = 0;
            lastSecond = System.currentTimeMillis();
        }

        g.drawString(String.format("%d FPS", fps), 15, 15);
    }
}

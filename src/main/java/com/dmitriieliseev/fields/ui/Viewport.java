package com.dmitriieliseev.fields.ui;

import com.dmitriieliseev.fields.physics.World;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@AllArgsConstructor
public class Viewport extends JPanel {
    private FPSLabel fpsLabel;
    private World world;

    @PostConstruct
    void construct() {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        fpsLabel.paint(g);
        world.getBodies().forEach(body -> {
            g.setColor(body.getColor());
            g.drawRect((int)body.getPosition().getX()-5,(int)body.getPosition().getY()-5,10, 10);
        });
    }
}

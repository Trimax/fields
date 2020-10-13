package com.dmitriieliseev.fields.ui;

import com.dmitriieliseev.fields.physics.World;
import com.dmitriieliseev.fields.rendering.Camera;
import com.dmitriieliseev.fields.rendering.Renderer;
import com.dmitriieliseev.fields.ui.listeners.CameraMoveListener;
import com.dmitriieliseev.fields.ui.listeners.CameraZoomListener;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

@Slf4j
@Component
@AllArgsConstructor
public class Viewport extends JPanel implements ComponentListener {
    private CameraZoomListener cameraZoomListener;
    private CameraMoveListener cameraMoveListener;
    private FPSLabel fpsLabel;
    private Renderer renderer;
    private Camera camera;
    private World world;

    @PostConstruct
    void construct() {
        setBackground(new Color(10, 10, 55));
        addMouseMotionListener(cameraMoveListener);
        addMouseWheelListener(cameraZoomListener);
        addMouseListener(cameraMoveListener);
        addComponentListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        fpsLabel.paint(g);
        renderer.render(g);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        camera.setViewportSize(getSize());
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}

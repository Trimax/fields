package com.dmitriieliseev.fields.ui;

import com.dmitriieliseev.fields.rendering.Renderer;
import com.dmitriieliseev.fields.ui.listeners.CameraMoveListener;
import com.dmitriieliseev.fields.ui.listeners.CameraZoomListener;
import com.dmitriieliseev.fields.ui.listeners.ViewportResizeListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class Viewport extends JPanel {
    private final ViewportResizeListener viewportResizeListener;
    private final CameraZoomListener cameraZoomListener;
    private final CameraMoveListener cameraMoveListener;
    private final FPSLabel fpsLabel;
    private final Renderer renderer;

    @PostConstruct
    void construct() {
        setBackground(new Color(10, 10, 55));

        viewportResizeListener.setViewportSizeSupplier(this::getSize);
        cameraMoveListener.setCursorConsumer(this::setCursor);

        addComponentListener(viewportResizeListener);
        addMouseMotionListener(cameraMoveListener);
        addMouseWheelListener(cameraZoomListener);
        addMouseListener(cameraMoveListener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        fpsLabel.paint(g);
        renderer.render(g);
    }
}

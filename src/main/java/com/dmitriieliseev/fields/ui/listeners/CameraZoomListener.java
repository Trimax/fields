package com.dmitriieliseev.fields.ui.listeners;

import com.dmitriieliseev.fields.rendering.Camera;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

@Component
@AllArgsConstructor
public class CameraZoomListener implements MouseWheelListener {
    private final Camera camera;

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        camera.zoom(e.getPreciseWheelRotation());
    }
}

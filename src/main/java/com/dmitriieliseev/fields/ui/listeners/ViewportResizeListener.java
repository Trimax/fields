package com.dmitriieliseev.fields.ui.listeners;

import com.dmitriieliseev.fields.rendering.Camera;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class ViewportResizeListener implements ComponentListener {
    private final Camera camera;
    private Supplier<Dimension> viewportSizeSupplier;

    public void setViewportSizeSupplier(Supplier<Dimension> viewportSizeSupplier) {
        this.viewportSizeSupplier = viewportSizeSupplier;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        camera.setViewportSize(viewportSizeSupplier.get());
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

package com.dmitriieliseev.fields.ui.listeners;

import com.dmitriieliseev.fields.rendering.Camera;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.springframework.stereotype.Component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class CameraMoveListener implements MouseMotionListener, MouseListener {
    private final Camera camera;

    private Vector2D origin = Vector2D.ZERO;

    @Override
    public void mouseDragged(MouseEvent e) {
        Vector2D offset = origin.subtract(new Vector2D(e.getX(), e.getY()));
        camera.move(offset);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1)
            origin = new Vector2D(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

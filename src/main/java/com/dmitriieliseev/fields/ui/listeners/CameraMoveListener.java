package com.dmitriieliseev.fields.ui.listeners;

import com.dmitriieliseev.fields.rendering.Camera;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class CameraMoveListener implements MouseMotionListener, MouseListener {
    private final Camera camera;
    private Consumer<Cursor> cursorConsumer;

    private Vector2D origin = Vector2D.ZERO;

    public void setCursorConsumer(Consumer<Cursor> cursorConsumer) {
        this.cursorConsumer = cursorConsumer;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Vector2D offset = origin.subtract(new Vector2D(e.getX(), e.getY()));
        camera.move(offset);
        this.origin = new Vector2D(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        cursorConsumer.accept(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        if (e.getButton() == 1)
            origin = new Vector2D(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cursorConsumer.accept(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

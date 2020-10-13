package com.dmitriieliseev.fields.rendering;

import com.dmitriieliseev.fields.common.Definitions;
import com.dmitriieliseev.fields.model.Body;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.springframework.stereotype.Component;

import java.awt.*;

@Slf4j
@Component
public class Camera {
    private Vector2D dimension = Definitions.viewportSize;
    private Vector2D position = Vector2D.ZERO;
    private Vector2D viewport = dimension;
    private double zoom = 100.0;

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getViewport() {
        return viewport;
    }

    public void setViewportSize(Dimension dimension) {
        this.dimension = new Vector2D(dimension.getWidth(), dimension.getHeight());
        this.viewport = new Vector2D(dimension.getWidth(), dimension.getHeight()); //.normalize().scalarMultiply(this.zoom);
        log.info("Camera viewport changed. Position: {}; Viewport: {}; Zoom: {}", this.position, this.viewport, this.zoom);
    }

    public void zoom(double zoom) {
        this.zoom = Math.max(1.0, Math.min(100.0, this.zoom + 0.1 * zoom));
       // this.viewport = new Vector2D(this.dimension.getX(), this.dimension.getY()).normalize().scalarMultiply(this.zoom);
        log.info("Camera zoom changed. Position: {}; Viewport: {}; Zoom: {}", this.position, this.viewport, this.zoom);
    }

    public void move(Vector2D offset) {
        this.position = this.position.add(offset.normalize());
        log.info("Camera position changed. Position: {}; Viewport: {}; Zoom: {}", this.position, this.viewport, this.zoom);
    }

    public boolean isVisible(Body body) {
        Vector2D halfSize = body.getSize().scalarMultiply(0.5);

        return isVisible(new Vector2D(body.getPosition().getX() - halfSize.getX(), body.getPosition().getY() - halfSize.getY())) ||
                isVisible(new Vector2D(body.getPosition().getX() - halfSize.getX(), body.getPosition().getY() + halfSize.getY())) ||
                isVisible(new Vector2D(body.getPosition().getX() + halfSize.getX(), body.getPosition().getY() - halfSize.getY())) ||
                isVisible(new Vector2D(body.getPosition().getX() + halfSize.getX(), body.getPosition().getY() + halfSize.getY()));
    }

    public boolean isVisible(Vector2D point) {
        Vector2D halfViewport = this.viewport.scalarMultiply(0.5);
        return between(this.position.getX() - halfViewport.getX(), this.position.getX() + halfViewport.getX(), point.getX()) && between(this.position.getY() - halfViewport.getY(), this.position.getY() + halfViewport.getY(), point.getY());
    }

    public boolean between(double left, double right, double value) {
        return left <= value && value <= right;
    }
}

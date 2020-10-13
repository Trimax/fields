package com.dmitriieliseev.fields.model;

import com.dmitriieliseev.fields.interfaces.Massive;
import com.dmitriieliseev.fields.interfaces.Volumetric;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.awt.*;
import java.util.UUID;

@Data
@Builder
public class Body implements Massive, Volumetric {
    private final String id = UUID.randomUUID().toString();
    private final double mass;
    private final Color color;
    private Vector2D position;
    private Vector2D velocity;
    private Vector2D size;

    public void apply(Vector2D force) {
        Vector2D acceleration = force.scalarMultiply(1.0 / mass);
        this.velocity = this.velocity.add(acceleration);
        this.position = this.position.add(velocity);
    }
}

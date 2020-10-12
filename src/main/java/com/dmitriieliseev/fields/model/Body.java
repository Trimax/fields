package com.dmitriieliseev.fields.model;

import com.dmitriieliseev.fields.interfaces.Massive;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.awt.*;

@Data
@Builder
public class Body implements Massive {
    private final double mass;
    private final Color color;
    private Vector2D position;
    private Vector2D velocity;
}

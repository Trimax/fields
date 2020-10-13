package com.dmitriieliseev.fields.rendering;

import com.dmitriieliseev.fields.physics.World;
import lombok.AllArgsConstructor;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
@AllArgsConstructor
public class Renderer {
    private final Camera camera;
    private final World world;

    public void render(Graphics g) {

        world.getBodies().forEach(body -> {
//            if (!camera.isVisible(body))
//                return;

            Vector2D leftTopCameraCorner = camera.getPosition().subtract(camera.getViewport().scalarMultiply(0.5));
            Vector2D projectionCoordinates = body.getPosition().subtract(leftTopCameraCorner);

            g.setColor(body.getColor());
            g.drawRect((int)projectionCoordinates.getX()-5,(int)projectionCoordinates.getY()-5,10, 10);
        });
    }
}

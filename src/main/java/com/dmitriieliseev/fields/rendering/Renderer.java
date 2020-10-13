package com.dmitriieliseev.fields.rendering;

import com.dmitriieliseev.fields.physics.World;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
@AllArgsConstructor
public class Renderer {
    private final Camera camera;
    private final World world;

    public void render(Graphics g) {
        world.getBodies().forEach(body -> {
            if (!camera.isVisible(body))
                return;

            g.setColor(body.getColor());
            g.drawRect((int)body.getPosition().getX()-5,(int)body.getPosition().getY()-5,10, 10);
        });
    }
}

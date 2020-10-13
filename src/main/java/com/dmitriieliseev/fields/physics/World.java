package com.dmitriieliseev.fields.physics;

import com.dmitriieliseev.fields.model.Body;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Getter
@Component
public class World {
    private final List<Body> bodies = new ArrayList<>();

    @PostConstruct
    void construct() {
        log.info("World constructed");

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Body body = Body.builder()
                    .mass(1.0)
                    .color(new Color(55 + random.nextInt(200), 55 + random.nextInt(200), 55 + random.nextInt(200)))
                    .position(new Vector2D(100 - random.nextInt(200), 100 - random.nextInt(200)))
                    .velocity(new Vector2D(0.5 - random.nextDouble(), 0.5 - random.nextDouble()))
                    .size(new Vector2D(0.1, 0.1))
                    .build();

            bodies.add(body);
        }
    }

    public void update() {
        for (Body body : bodies) {
            body.setPosition(body.getPosition().add(body.getVelocity()));

//            if (body.getPosition().getX() > 150)
//                body.setVelocity(new Vector2D(-body.getVelocity().getX(), body.getVelocity().getY()));
//
//            if (body.getPosition().getX() < 150)
//                body.setVelocity(new Vector2D(-body.getVelocity().getX(), body.getVelocity().getY()));
//
//            if (body.getPosition().getY() > 150)
//                body.setVelocity(new Vector2D(body.getVelocity().getX(), -body.getVelocity().getY()));
//
//            if (body.getPosition().getY() < -150)
//                body.setVelocity(new Vector2D(body.getVelocity().getX(), -body.getVelocity().getY()));
        }
    }
}

package com.dmitriieliseev.fields.physics;

import com.dmitriieliseev.fields.model.Body;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Component
public class World {
    private final List<Body> bodies = new ArrayList<>();

    @PostConstruct
    void construct() {
        log.info("World constructed");

//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            Body body = Body.builder()
//                    .mass(2500.0)
//                    .color(new Color(55 + random.nextInt(200), 55 + random.nextInt(200), 55 + random.nextInt(200)))
//                    .position(new Vector2D(100 - random.nextInt(200), 100 - random.nextInt(200)))
//                    .velocity(new Vector2D(0.1 - random.nextDouble() * 0.2, 0.1 - random.nextDouble() * 0.2))
//                    .size(new Vector2D(0.1, 0.1))
//                    .build();
//
//            bodies.add(body);
//        }

        bodies.add(Body.builder()
                .mass(2500.0)
                .color(Color.RED)
                .position(new Vector2D(-100, 0))
                .size(new Vector2D(0.1, 0.1))
                .velocity(new Vector2D(0.0, 0.1))
                .build());

        bodies.add(Body.builder()
                .mass(2500.0)
                .color(Color.YELLOW)
                .position(new Vector2D(100, 0))
                .size(new Vector2D(0.1, 0.1))
                .velocity(new Vector2D(0.0, -0.1))
                .build());

//        bodies.add(Body.builder()
//                .mass(2500.0)
//                .color(Color.WHITE)
//                .position(new Vector2D(100, 100))
//                .size(new Vector2D(0.1, 0.1))
//                .velocity(Vector2D.ZERO)
//                .build());
//
//        bodies.add(Body.builder()
//                .mass(2500.0)
//                .color(Color.GREEN)
//                .position(new Vector2D(-100, 100))
//                .size(new Vector2D(0.1, 0.1))
//                .velocity(Vector2D.ZERO)
//                .build());
    }

    public void update() {
        Map<String, Vector2D> forcesMap = StreamEx.of(bodies).parallel().toMap(Body::getId, this::getForce);

        StreamEx.of(bodies)
                .parallel()
                .forEach(body -> body.apply(forcesMap.get(body.getId())));
//
//
//        for (Body body : bodies) {
//            body.setPosition(body.getPosition().add(body.getVelocity()));
//
////            if (body.getPosition().getX() > 150)
////                body.setVelocity(new Vector2D(-body.getVelocity().getX(), body.getVelocity().getY()));
////
////            if (body.getPosition().getX() < 150)
////                body.setVelocity(new Vector2D(-body.getVelocity().getX(), body.getVelocity().getY()));
////
////            if (body.getPosition().getY() > 150)
////                body.setVelocity(new Vector2D(body.getVelocity().getX(), -body.getVelocity().getY()));
////
////            if (body.getPosition().getY() < -150)
////                body.setVelocity(new Vector2D(body.getVelocity().getX(), -body.getVelocity().getY()));
//        }
    }

    private Vector2D getForce(Body body) {
        Vector2D force = Vector2D.ZERO;

        for (Body currentBody : bodies) {
            if (currentBody == body)
                continue;

            double distance = Vector2D.distanceSq(body.getPosition(), currentBody.getPosition());
            if (distance < 0.01) {
                continue;
            }

            Vector2D currentForce = currentBody
                    .getPosition()
                    .subtract(body.getPosition())
                    .normalize()
                    .scalarMultiply((0.01 * body.getMass() * currentBody.getMass()) / distance);

            force = force.add(currentForce);
        }

        return force;
    }
}

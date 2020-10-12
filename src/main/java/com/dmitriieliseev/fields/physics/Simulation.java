package com.dmitriieliseev.fields.physics;

import com.dmitriieliseev.fields.common.Definitions;
import com.dmitriieliseev.fields.ui.Viewport;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@AllArgsConstructor
public class Simulation implements Runnable {
    private Viewport viewport;
    private World world;

    @PostConstruct
    void construct() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        long prevTime = System.currentTimeMillis();
        long currTime;

        while (!Thread.interrupted()) {
            currTime = System.currentTimeMillis();

            if ((currTime - prevTime) > Definitions.physicsFps) {
                update(currTime - prevTime);
                viewport.repaint();

                prevTime = currTime;
            }
        }
    }

    public void update(long dt) {
        int frames = (int) (dt / Definitions.physicsFps);

        for (int frame = 0; frame <= frames; frame++)
            world.update();
    }
}

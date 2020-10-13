package com.dmitriieliseev.fields.ui;

import com.dmitriieliseev.fields.common.Definitions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@AllArgsConstructor
public class Workspace extends JFrame {
    private final MenuBar menuBar;
    private final Viewport viewport;

    @PostConstruct
    void construct() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fields simulation");
        setSize((int) Definitions.viewportSize.getX(), (int) Definitions.viewportSize.getY());
        setLocationRelativeTo(null);
        setJMenuBar(menuBar);

        add(viewport);
    }
}

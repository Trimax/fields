package com.dmitriieliseev.fields.ui;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@AllArgsConstructor
public class Workspace extends JFrame {
    private MenuBar menuBar;
    private Viewport viewport;

    @PostConstruct
    void construct() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fields simulation");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setJMenuBar(menuBar);

        add(viewport);
    }
}

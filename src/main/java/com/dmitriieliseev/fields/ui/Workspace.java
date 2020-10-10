package com.dmitriieliseev.fields.ui;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@AllArgsConstructor
public class Workspace extends JFrame {
    private MenuBar menuBar;

    @PostConstruct
    void construct() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fields simulation");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setJMenuBar(menuBar);
    }

    private void createLayout(JComponent... arg) {
        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }
}

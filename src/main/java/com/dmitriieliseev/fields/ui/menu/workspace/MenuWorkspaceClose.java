package com.dmitriieliseev.fields.ui.menu.workspace;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MenuWorkspaceClose extends JMenuItem implements ActionListener {
    @PostConstruct
    void construct() {
        setText("Close");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

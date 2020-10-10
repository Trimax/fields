package com.dmitriieliseev.fields.ui.menu.workspace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Slf4j
@Component
public class MenuWorkspaceLoad extends JMenuItem implements ActionListener {
    @PostConstruct
    void construct() {
        setText("Load");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        log.info("Load workspace");
    }
}

package com.dmitriieliseev.fields.ui.menu;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
public class MenuSimulation extends JMenu {
    @PostConstruct
    void construct() {
        setText("Simulation");
    }
}

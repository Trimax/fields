package com.dmitriieliseev.fields.ui;

import com.dmitriieliseev.fields.ui.menu.MenuSimulation;
import com.dmitriieliseev.fields.ui.menu.MenuWorkspace;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@AllArgsConstructor
public class MenuBar extends JMenuBar {
    private final MenuWorkspace menuWorkspace;
    private final MenuSimulation menuSimulation;

    @PostConstruct
    void construct() {
        add(menuWorkspace);
        add(menuSimulation);
    }
}

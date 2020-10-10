package com.dmitriieliseev.fields.ui.menu;

import com.dmitriieliseev.fields.ui.menu.workspace.MenuWorkspaceClose;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@AllArgsConstructor
public class MenuWorkspace extends JMenu {
    private MenuWorkspaceClose menuWorkspaceClose;

    @PostConstruct
    void construct() {
        setText("Workspace");

        add(menuWorkspaceClose);
    }
}

package com.dmitriieliseev.fields.ui.menu;

import com.dmitriieliseev.fields.ui.menu.workspace.MenuWorkspaceClose;
import com.dmitriieliseev.fields.ui.menu.workspace.MenuWorkspaceLoad;
import com.dmitriieliseev.fields.ui.menu.workspace.MenuWorkspaceNew;
import com.dmitriieliseev.fields.ui.menu.workspace.MenuWorkspaceSave;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@AllArgsConstructor
public class MenuWorkspace extends JMenu {
    private MenuWorkspaceNew menuWorkspaceNew;
    private MenuWorkspaceSave menuWorkspaceSave;
    private MenuWorkspaceLoad menuWorkspaceLoad;
    private MenuWorkspaceClose menuWorkspaceClose;

    @PostConstruct
    void construct() {
        setText("Workspace");

        add(menuWorkspaceNew);
        add(menuWorkspaceSave);
        add(menuWorkspaceLoad);
        addSeparator();
        add(menuWorkspaceClose);
    }
}

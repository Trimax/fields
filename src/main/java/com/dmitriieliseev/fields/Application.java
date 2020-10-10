package com.dmitriieliseev.fields;

import com.dmitriieliseev.fields.ui.Workspace;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.awt.*;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(Application.class).headless(false).run(args);
        EventQueue.invokeLater(() -> ctx.getBean(Workspace.class).setVisible(true));
    }
}

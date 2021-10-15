package com.aneirine.generation_tree.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class SpringFXMLLoader {
    private final ResourceBundle resourceBundle;
    private final ApplicationContext context;

    @Autowired
    public SpringFXMLLoader(ApplicationContext context, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        this.context = context;
    }

    public Parent load(String fxmlPath) throws IOException {
        FXMLLoader loader = getLoader(fxmlPath);
        loader.setControllerFactory(context::getBean);
        loader.setResources(resourceBundle);
        return loader.load();
    }

    public FXMLLoader getLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        return loader;
    }

    public Object getElementFromLoader(String fxmlViewPath, String elementId) {
        FXMLLoader loader = getLoader(fxmlViewPath);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loader.getNamespace().get(elementId);
    }

}

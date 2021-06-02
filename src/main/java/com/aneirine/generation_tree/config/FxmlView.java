package com.aneirine.generation_tree.config;

import java.util.ResourceBundle;

public enum FxmlView {

    MAIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("main.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/main.fxml";
        }
    },

    CREATE_FAMILY {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("create-family.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/create_family.fxml";
        }
    };

    public abstract String getTitle();
    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}


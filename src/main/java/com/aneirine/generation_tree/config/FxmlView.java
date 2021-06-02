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

    FAMILY {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("create-family.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/create_family.fxml";
        }
    },

    FAMILY_MEMBER_BUTTON {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("create-family-member.button.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/add_family_member_first_screen.fxml";
        }
    },

    FAMILY_MEMBER {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("create-family-member.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/create_family_member.fxml";
        }
    },

    MEMBER {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("member.icon.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/member.fxml";
        }
    };

    public abstract String getTitle();

    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key) {
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}


module carpetas {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens carpetas.GUI to javafx.fxml;
    exports carpetas.GUI;
}

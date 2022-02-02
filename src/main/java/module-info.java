module carpetas {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;

    opens carpetas.GUI to javafx.fxml;
    exports carpetas.GUI;
}

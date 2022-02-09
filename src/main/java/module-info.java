module carpetas {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;
    requires com.jfoenix;

    opens carpetas.GUI to javafx.fxml;
    exports carpetas.GUI;
    exports carpetas.clases;
}

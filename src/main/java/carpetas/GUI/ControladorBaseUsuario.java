package carpetas.GUI;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.layout.Pane;


public class ControladorBaseUsuario {

    @FXML
    private JFXButton Boton1;

    @FXML
    private JFXButton boton2;

    @FXML
    private JFXButton boton3;

    @FXML
    private Pane mainPane;


    @FXML
    void initialize(){
    }

    
    @FXML
    void pressBoton1(ActionEvent event) {
        CargadorFXML obj = new CargadorFXML();        
        mainPane.getChildren().setAll(obj.getPane("Vista Fundación"));
        //Boton1.setStyle("-fx-background-color : rgb(9, 0, 90)");
        
    }

    @FXML
    void pressBoton2(ActionEvent event) {
        CargadorFXML obj = new CargadorFXML();        
        mainPane.getChildren().setAll(obj.getPane("imageTest"));
    }

    @FXML
    void pressBoton3(ActionEvent event) {

    }


    void currentScene(String vista){
        if (vista.equals("XD")){

        }
    }
}

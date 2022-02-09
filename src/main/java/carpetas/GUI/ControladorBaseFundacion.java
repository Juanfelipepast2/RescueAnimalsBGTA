package carpetas.GUI;


import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import carpetas.clases.Fundacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ControladorBaseFundacion {

    private Fundacion fund;

    private Stage stage;

    @FXML
    private JFXButton btnAnimalesFundacion;

    @FXML
    private JFXButton btnCerrarSesion;

    @FXML
    private JFXButton btnFundacion;

    @FXML
    private Pane mainPane;

    @FXML
    void verFundacion(ActionEvent event) throws IOException{        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/carpetas/view/Vista Fundación.fxml"));;
        Pane pane = fxmlLoader.load();

        VistaFundacionControlador vistaFund = fxmlLoader.getController();        
        vistaFund.setFund(fund);
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void verAnimalesFundacion(ActionEvent event) {

    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException{
        Parent root;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/carpetas/view/InicioDeSesionNormal.fxml"));
        root = loader.load();         
        
        ControllerInicioDeSesion controlInicio = loader.getController();        
        Scene scene = new Scene(root);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);        
        stage.show();
        
    }

    void setFundacion(Fundacion fund){
        this.fund = fund;
        btnFundacion.setText(fund.getNombre_Fun());

    }

}

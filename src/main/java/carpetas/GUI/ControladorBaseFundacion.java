package carpetas.GUI;


import java.io.IOException;


import com.jfoenix.controls.JFXButton;

import carpetas.clases.Fundacion;
import carpetas.sql_clases.CRUD;
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
    private JFXButton btnListaAnimales;

    @FXML
    private Pane mainPane;

    @FXML
    void verFundacion(ActionEvent event) throws IOException{  
        fund = CRUD.leerCorreoFundacion(fund.getCorreo_Electronico_Fun());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/carpetas/view/VistaFundacion.fxml"));;
        Pane pane = fxmlLoader.load();

        ControladorVistaFundacion vistaFund = fxmlLoader.getController();        
        vistaFund.setFund(fund);        
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void verAnimalesFundacion(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/carpetas/view/VistaAgregarAnimalFundacion.fxml"));;
        Pane pane = fxmlLoader.load();
        

        ControladorAgregarAnimalFundacion addAnimal = fxmlLoader.getController();        
        addAnimal.setFund(fund);
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void verListaAnimales(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/carpetas/view/ListaAnimalesFundacion.fxml"));;
        Pane pane = fxmlLoader.load();
        

        ControladorListaAnimalesFundacion listaAni = fxmlLoader.getController();        
        listaAni.setFund(fund);
        mainPane.getChildren().setAll(pane);
        

    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException{
        Parent root;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/carpetas/view/InicioDeSesionNormal.fxml"));
        root = loader.load();         
        
        //ControllerInicioDeSesion controlInicio = loader.getController();        EL CONTROLADOR SOLO SE CARGA SI SE LE VA  A MANDAR INFORMACIÓN     
        Scene scene = new Scene(root);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);        
        stage.centerOnScreen();
        stage.show();
        
    }

    void setFundacion(Fundacion fund) throws IOException{
        this.fund = fund;
        btnFundacion.setText(fund.getNombre_Fun());
        verFundacion(new ActionEvent());

    }

}

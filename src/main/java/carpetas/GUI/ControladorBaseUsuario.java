package carpetas.GUI;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import carpetas.clases.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ControladorBaseUsuario {

    private Stage stage;
    private Usuario user;

    @FXML
    private JFXButton btnAdoptar;

    @FXML
    private JFXButton btnAnimalesAdoptados;

    @FXML
    private JFXButton btnCerrarSesion;

    @FXML
    private JFXButton btnPerfil;

    @FXML
    private Pane mainPane;

    @FXML
    void initialize() {

    }

    @FXML
    void verPerfil(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/carpetas/view/vistaUsuario.fxml"));;
        Pane pane = fxmlLoader.load();

        ControladorVistaUsuario vistaUser = fxmlLoader.getController();        
        vistaUser.setUser(user);
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void verAnimalesAdoptados(ActionEvent event) {
        CargadorFXML obj = new CargadorFXML();
        mainPane.getChildren().setAll(obj.getPane("imageTest"));
    }

    @FXML
    void verAdoptar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/carpetas/view/VistaAdopcion.fxml"));;
        Pane pane = fxmlLoader.load();

        ControladorAdoptarAnimal adopt = fxmlLoader.getController();        
        adopt.initialize(user);
        mainPane.getChildren().setAll(pane);
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


    void setUser(Usuario user) throws IOException {
        this.user = user;
        btnPerfil.setText(this.user.getUsername());
        
        
    }
}

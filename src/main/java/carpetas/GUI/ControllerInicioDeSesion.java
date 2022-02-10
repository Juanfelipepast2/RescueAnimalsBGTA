package carpetas.GUI;

import java.io.IOException;

import carpetas.clases.*;
import carpetas.clases.Usuario;
import carpetas.sql_clases.CRUD;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControllerInicioDeSesion {

    @FXML
    private Button BtnIniciarSesion;

    @FXML
    private Button BtnRegistro;

    @FXML
    private CheckBox CheckBoxClave;

    @FXML
    private TextField TextClave;

    @FXML
    private PasswordField TextClave2;

    @FXML
    private TextField TextUsuario;

    private Stage stage;
    
    
    @FXML
    void irRegistro(ActionEvent event) throws IOException{
        Parent root;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/carpetas/view/RegistroNormal.fxml"));
        root = loader.load();         
        ControllerRegistroNormal registro = loader.getController();        
        Scene scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);        
        stage.show();
    }


    @FXML
    void IniciarSesionClic(ActionEvent event) throws IOException {
        Usuario tempUser = CRUD.leerUsuario(TextUsuario.getText());
        Fundacion tempFund = CRUD.leerCorreoFundacion(TextUsuario.getText());
        if (tempUser != null) {

            if (passCheck(tempUser.getContraseña())) {
                cambiarVentana(event, "/carpetas/view/Base_vista_usuario", tempUser, null);
            }
            return;
        } else if (tempFund != null) {

            if (passCheck(tempFund.getContrasena_Fun())) {
                cambiarVentana(event, "/carpetas/view/Base_vista_fundacion", null, tempFund);
            }
            return;
        } else {
            AlertaError("Inicio de sesión", "No existe un usuario o una fundación con ese correo");
        }
    }

    boolean passCheck(String pass) {
        if (pass.equals(TextClave.getText()) || pass.equals(TextClave2.getText())) {
            System.out.println("Bienvenido");
            return true;
        } else {
            AlertaError("Inicio de sesión", "Usuario o contraseña incorrectos");
            return false;
        }
    }

    @FXML
    void mostrarContrasena(ActionEvent event) {
        if (CheckBoxClave.isSelected()) {
            TextClave.setText(TextClave2.getText());
            TextClave2.setVisible(false);
            TextClave.setVisible(true);
            return;
        }
        TextClave2.setText(TextClave2.getText());
        TextClave.setVisible(false);
        TextClave2.setVisible(true);

    }

    void cambiarVentana(ActionEvent event, String view, Usuario usr, Fundacion fnd) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view + ".fxml"));
        Parent root;
        root = loader.load();
        if (usr != null) {
            ControladorBaseUsuario controlUser = new ControladorBaseUsuario();
            
            
            controlUser = loader.getController();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);            
            controlUser.setUser(usr);
            
        } else if (fnd != null){
            ControladorBaseFundacion controlFun = new ControladorBaseFundacion();            
            controlFun = loader.getController();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);            
            controlFun.setFundacion(fnd);
        }
        stage.show();
    }

    @FXML
    void AlertaInformacion(String Titulo, String Mensaje) {
        Alert AlertaInformacion = new Alert(AlertType.NONE, Mensaje, ButtonType.OK);
        AlertaInformacion.setTitle(Titulo);
        AlertaInformacion.showAndWait();
    }

    @FXML
    void AlertaError(String Titulo, String Mensaje) {
        Alert AlertaError = new Alert(AlertType.ERROR, Mensaje, ButtonType.OK);
        AlertaError.setTitle(Titulo);
        AlertaError.showAndWait();
    }
}

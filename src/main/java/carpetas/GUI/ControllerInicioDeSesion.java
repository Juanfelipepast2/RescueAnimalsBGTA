package carpetas.GUI;

import carpetas.clases.*;
import carpetas.clases.Usuario;
import carpetas.sql_clases.CRUD;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    @FXML
    void IniciarSesionClic(ActionEvent event) {
        Usuario tempUser = CRUD.leerUsuario(TextUsuario.getText());
        Fundacion tempFund = CRUD.leerCorreoFundacion(TextUsuario.getText());
        if (tempUser != null) {
            passCheck(tempUser.getContraseña());
            return;
        } else  if(tempFund != null){
            passCheck(tempFund.getContrasena_Fun());
            return;
        }  else {
            System.out.println("No existe un usuario o fundación con ese correo");
        }   
    }

    void passCheck(String pass){
        if(pass.equals(TextClave.getText()) || pass.equals(TextClave2.getText())){
            System.out.println("Bienvenido");
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
    }



    @FXML
    void mostrarContrasena(ActionEvent event) {
        if(CheckBoxClave.isSelected()){
            TextClave.setText(TextClave2.getText());
            TextClave2.setVisible(false);
            TextClave.setVisible(true);
            return;
        } 
            TextClave2.setText(TextClave2.getText());
            TextClave.setVisible(false);
            TextClave2.setVisible(true);
        
    }

}

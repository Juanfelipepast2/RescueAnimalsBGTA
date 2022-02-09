package carpetas.GUI;

import carpetas.clases.Usuario;
import carpetas.sql_clases.CRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.scene.Scene;

public class ControllerRegistroNormal {

    @FXML
    private Button BtnCrearCuenta;

    @FXML
    private Button BtnVolver;

    @FXML
    private TextField TextApellidos;

    @FXML
    private TextField TextCedula;

    @FXML
    private PasswordField TextClave;

    @FXML
    private TextField TextCorreo;

    @FXML
    private TextField TextNombres;

    @FXML
    private PasswordField TextRepetirClave;

    @FXML
    private TextField TextTelefono;

    @FXML
    private TextField TextUsuario;

    @FXML
    private void Volver(ActionEvent event) {
        
    }

    @FXML
    void CrearCuentaClic(ActionEvent event) {
        //Crear cuenta revisando que el correo no exista en la base de datos
        int Cedula = Integer.parseInt(TextCedula.getText());
        int Telefono = Integer.parseInt(TextTelefono.getText());
        Usuario temp = new Usuario(Cedula, TextUsuario.getText(), TextNombres.getText(), TextApellidos.getText(), TextClave.getText(), TextCorreo.getText(), Telefono);
        if (CRUD.leerUsuario(temp.getUsername())==null && CRUD.leerCedula(temp.getCedula())==null && CRUD.leerCorreo(temp.getCorreo())==null) {    
            if (TextClave.getText().equals(TextRepetirClave.getText())) {
                    CRUD.crearUsuario(temp);
                    AlertaInformacion("Registro", "La cuenta se ha creado correctamente");
                } else {
                    AlertaError("Registro", "Las contraseñas no coinciden");
                }
        } else {
            if(CRUD.leerUsuario(TextUsuario.getText())!=null) {
                AlertaError("Registro", "El nombre de usuario ya esta vinculado a una cuenta");
            }
            else if(CRUD.leerCedula(Cedula)!=null) {
                AlertaError("Registro", "El numero de cedula ingresado ya esta vinculada a una cuenta");
            }
            else if(CRUD.leerCorreo(TextCorreo.getText())!=null) {
                AlertaError("Registro", "El correo electronico ingresado ya esta vinculado a una cuenta");
            }
        }
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

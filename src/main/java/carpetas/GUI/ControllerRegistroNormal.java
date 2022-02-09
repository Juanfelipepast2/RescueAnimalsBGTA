package carpetas.GUI;

import carpetas.clases.Usuario;
import carpetas.sql_clases.CRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    void CrearCuentaClic(ActionEvent event) {
        //Crear cuenta revisando que el correo no exista en la base de datos
        int Cedula = Integer.parseInt(TextCedula.getText());
        int Telefono = Integer.parseInt(TextTelefono.getText());
        Usuario temp = new Usuario(Cedula, TextUsuario.getText(), TextNombres.getText(), TextApellidos.getText(), TextClave.getText(), TextCorreo.getText(), Telefono);
        if (CRUD.leerUsuario(temp.getUsername())==null && CRUD.leerCedula(temp.getCedula())==null && CRUD.leerCorreo(temp.getCorreo())==null) {    
            if (TextClave.getText().equals(TextRepetirClave.getText())) {
                    CRUD.crearUsuario(temp);
                    System.out.println("Cuenta creada");
                } else {
                    System.out.println("Las contraseñas no coinciden");
                }
        } else {
            if(CRUD.leerUsuario(TextUsuario.getText())!=null) {
                System.out.println("El usuario ya existe");
            }
            else if(CRUD.leerCedula(Cedula)!=null) {
                System.out.println("La cedula ya existe");
            }
            else if(CRUD.leerCorreo(TextCorreo.getText())!=null) {
                System.out.println("El correo ya existe");
            }
        }
    }
}

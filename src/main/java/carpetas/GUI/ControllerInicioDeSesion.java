package carpetas.GUI;
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
        Usuario temp = CRUD.leerUsuario(TextUsuario.getText());
        // if (temp != null) {
        //     if (temp.getContraseña().equals(TextClave.getText())) {
        //         System.out.println("Bienvenido");
        //     } else {
        //         System.out.println("Usuario o contraseña incorrectos");
        //     }
        // } else {
        //     System.out.println("Usuario o contraseña incorrectos");
        // }
        System.out.println(temp.getContraseña());
    }

}

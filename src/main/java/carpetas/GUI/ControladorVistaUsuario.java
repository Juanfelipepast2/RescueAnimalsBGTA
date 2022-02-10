package carpetas.GUI;

import com.jfoenix.controls.JFXButton;

import carpetas.clases.Usuario;
import carpetas.sql_clases.CRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ControladorVistaUsuario {

    Usuario user;

    @FXML
    private Label apellidoUsuario;

    @FXML
    private JFXButton btnImagen;

    @FXML
    private Label cedulaUsuario;

    @FXML
    private Label correoElectronicoUsuario;

    @FXML
    private GridPane gridUsuario;

    @FXML
    private ImageView imagenUsuario;

    @FXML
    private Label nicknameUsuario;

    @FXML
    private Label nombreUsuario;

    @FXML
    private Label telefonoUsuario;

    @FXML
    void cambiarImagen(ActionEvent event) {
        user.selectImage();
        imagenUsuario.setImage(new Image(user.getRutaFotoElegida()));
        CRUD.updatePhotoUser(user);
    }

    void setUser(Usuario user){
        this.user = user;
        nombreUsuario.setText(user.getNombre());
        apellidoUsuario.setText(user.getApellido());
        cedulaUsuario.setText(String.valueOf(user.getCedula()));
        correoElectronicoUsuario.setText(user.getCorreo());
        nicknameUsuario.setText(user.getUsername());
        telefonoUsuario.setText(String.valueOf(user.getNumeroTelefonico()));
        if(user.getFotoMostrable() != null){
            imagenUsuario.setImage(new Image(user.getFotoMostrable()));
        }
    }

}

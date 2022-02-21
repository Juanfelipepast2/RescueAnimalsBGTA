package carpetas.GUI;

import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import carpetas.clases.Animal;
import carpetas.clases.Usuario;
import carpetas.sql_clases.CRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ControladorVistaUsuario {

    private Usuario user;

    private List<Animal> listaAnimales = new ArrayList<>();

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
        CRUD.updatePhotoUser(user);
        user = CRUD.leerUsuario(user.getUsername());
        imagenUsuario.setImage(new Image(user.getFotoMostrable()));
    }

    void setUser(Usuario user){
        this.user = user;
        getData();
        nombreUsuario.setText(user.getNombre());
        apellidoUsuario.setText(user.getApellido());
        cedulaUsuario.setText(String.valueOf(user.getCedula()));
        correoElectronicoUsuario.setText(user.getCorreo());
        nicknameUsuario.setText(user.getUsername());
        telefonoUsuario.setText(String.valueOf(user.getNumeroTelefonico()));
        if(user.getFotoMostrable() != null){
            imagenUsuario.setImage(new Image(user.getFotoMostrable()));
        }

        int columna = 0;
        int fila = 0;

        try{

            for (int i = 0; i<listaAnimales.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/carpetas/view/ItemAnimalUsuario.fxml"));;
                VBox vbox = fxmlLoader.load();

                ControladorItemAnimalUsuario item = fxmlLoader.getController();
                item.initAnimal(listaAnimales.get(i));

                gridUsuario.add(vbox, columna, fila++);

                GridPane.setMargin(vbox, new Insets(20));
                System.out.println(i);
            }

        }catch(Exception e){
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    void getData(){
        
        listaAnimales = CRUD.LeerAnimalesCedula(user.getCedula());
    }

}

package carpetas.GUI;

import java.io.InputStream;
import java.util.ArrayList;



import carpetas.clases.Animal;
import carpetas.clases.Usuario;
import carpetas.sql_clases.CRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControladorAdoptarAnimal {
    @FXML
    private Button botonAdoptarPanel;

    @FXML
    private Button botonMiUsuario;

    @FXML
    private ImageView fotoAnimalPanel;

    @FXML
    private Label fundacionAnimalPanel;

    @FXML
    private Label nombreAnimalPanel;

    @FXML
    private HBox panelAdoptarAnimal;

    @FXML
    private Label razaAnimalPanel;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label tipoAnimalPanel;

    @FXML
    private GridPane grid;

    @FXML
    void adoptar(ActionEvent event) {
        try {            
            
            grid.getChildren().clear();
            clear();
            CRUD.updateAnimalAdoptado(currentUser, currentAnimal.getID_Animal());
            initialize(currentUser);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Usuario currentUser;

    private Animal currentAnimal;

    private ArrayList<Animal> listaAnimales;
    private MyListener myListener;

    private void elegirAnimal(Animal animal) {
        try {

            currentAnimal = animal;

            nombreAnimalPanel.setText(animal.getNombre_Animal());
            tipoAnimalPanel.setText(animal.getTipo_Animal());
            razaAnimalPanel.setText(animal.getRaza_Animal());
            fundacionAnimalPanel.setText(animal.getNombre_Fund());
            InputStream bin = animal.getFotoMostrable();
            fotoAnimalPanel.setImage(new Image(bin));

            bin.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(Usuario user) {
        imgUrl = fotoAnimalPanel.getImage().getUrl();
        getData();
        currentUser = user;

        botonMiUsuario.setText(currentUser.getUsername());

        if (listaAnimales.size() > 0) {
            // elegirAnimal(listaAnimales.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Animal animal) {
                    animal = CRUD.leerAnimal(animal.getID_Animal());
                    elegirAnimal(animal);
                }

            };
        }

        int columna = 0;
        int fila = 0;

        try {

            for (int i = 0; i < listaAnimales.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/carpetas/view/Animal.fxml"));

                VBox vbox = fxmlLoader.load();

                ControladorAnimalItem item = fxmlLoader.getController();
                item.initAnimal(listaAnimales.get(i), myListener);

                grid.add(vbox, columna, fila++);

                GridPane.setMargin(vbox, new Insets(30));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void getData() {
        listaAnimales = null;
        listaAnimales = CRUD.LeerAnimales();

    }


    private String imgUrl;

    private void clear(){
        nombreAnimalPanel.setText("Nombre del animal");
        fotoAnimalPanel.setImage(new Image(imgUrl));
        tipoAnimalPanel.setText("Tipo");
        razaAnimalPanel.setText("Raza");
        fundacionAnimalPanel.setText("Fundacion");
    }
}

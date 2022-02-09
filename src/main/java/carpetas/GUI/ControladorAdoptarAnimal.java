package carpetas.GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import carpetas.clases.Animal;
import carpetas.sql_clases.CRUD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ControladorAdoptarAnimal implements Initializable{
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


    private ArrayList<Animal> listaAnimales;
    private MyListener myListener;

    private void elegirAnimal(Animal animal){
        nombreAnimalPanel.setText(animal.getNombre_Animal());
        tipoAnimalPanel.setText(animal.getTipo_Animal());
        razaAnimalPanel.setText(animal.getRaza_Animal());
        fundacionAnimalPanel.setText(animal.getNombre_Fund());
    }

    @Override
    public void initialize(URL Location, ResourceBundle resources){
        getData();

        if(listaAnimales.size() > 0) {
            elegirAnimal(listaAnimales.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Animal animal) {
                    elegirAnimal(animal);
                }   
            };
        }

        int columna = 0;
        int fila = 0;

        try{

            for (int i = 0; i<listaAnimales.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/carpetas/view/Animal.fxml"));;
                VBox vbox = fxmlLoader.load();

                ControladorAnimalItem item = fxmlLoader.getController();
                item.initAnimal(listaAnimales.get(i), myListener);

                grid.add(vbox, columna, fila++);

                GridPane.setMargin(vbox, new Insets(20));
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    private void getData(){
        listaAnimales = CRUD.LeerAnimales();

    }
}

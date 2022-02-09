package carpetas.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import carpetas.clases.Animal;

public class ControladorAnimalItem {

    @FXML
    private ImageView fotoAnimalItem;

    @FXML
    private Label fundacionAnimalItem;

    @FXML
    private Label nombreAnimalItem;

    @FXML
    private Label razaAnimalItem;

    @FXML
    private Label tipoAnimalItem;

    public void initAnimal(Animal obj){
        nombreAnimalItem.setText(obj.getNombre_Animal());
        fundacionAnimalItem.setText("Fundacion: " + obj.getNombre_Fund());
        razaAnimalItem.setText("Raza: " + obj.getRaza_Animal());
        tipoAnimalItem.setText("Tipo: " + obj.getTipo_Animal());
    }
}

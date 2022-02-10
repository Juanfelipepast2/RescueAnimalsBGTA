package carpetas.GUI;

import carpetas.clases.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorItemAnimalFundacion {

    @FXML
    private ImageView fotoAnimalItemFundacion;

    @FXML
    private Label nombreAnimalItemFundacion;

    @FXML
    private Label razaAnimalItemFundacion;

    @FXML
    private Label tipoAnimalItemFundacion;

    public void initAnimal(Animal animal){
        fotoAnimalItemFundacion.setImage(new Image(animal.getFotoMostrable()));
        nombreAnimalItemFundacion.setText(animal.getNombre_Animal());
        razaAnimalItemFundacion.setText(animal.getRaza_Animal());
        tipoAnimalItemFundacion.setText(animal.getTipo_Animal());
    }
}

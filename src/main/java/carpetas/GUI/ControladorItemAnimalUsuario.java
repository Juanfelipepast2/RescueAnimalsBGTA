package carpetas.GUI;
import carpetas.clases.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorItemAnimalUsuario {
    @FXML
    private ImageView fotoAnimalUsuario;

    @FXML
    private Label nombreAnimalUsuario;

    @FXML
    private Label razaAnimalUsuario;

    @FXML
    private Label tipoAnimalUsuario;

    public void initAnimal(Animal animal){
        fotoAnimalUsuario.setImage(new Image(animal.getFotoMostrable()));
        nombreAnimalUsuario.setText(animal.getNombre_Animal());
        razaAnimalUsuario.setText(animal.getRaza_Animal());
        tipoAnimalUsuario.setText(animal.getTipo_Animal());
    }
}

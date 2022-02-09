package carpetas.GUI;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    @FXML
    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(animal);
    }

    private Animal animal;
    private MyListener myListener;

    public void initAnimal(Animal obj, MyListener myListener){
        this.myListener = myListener;
        this.animal = obj;
        nombreAnimalItem.setText(obj.getNombre_Animal());
        fundacionAnimalItem.setText("Fundacion: " + obj.getNombre_Fund());
        razaAnimalItem.setText("Raza: " + obj.getRaza_Animal());
        tipoAnimalItem.setText("Tipo: " + obj.getTipo_Animal());
        fotoAnimalItem.setImage(new Image(obj.getFotoMostrable()));
    }
}

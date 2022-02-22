package carpetas.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

import carpetas.clases.Animal;
import carpetas.clases.Fundacion;
import carpetas.sql_clases.CRUD;

public class ControladorAgregarAnimalFundacion {

    private Fundacion fnd;
    private Animal animal = new Animal();
    private String imgUrl;

    @FXML
    private Button botonAgregarAnimal;

    @FXML
    private Button botonImagen;

    @FXML
    private TextField textoNombreAnimal;

    @FXML
    private TextField textoRazaAnimal;

    @FXML
    private TextField textoTipoAnimal;

    @FXML
    private ImageView vistaImagen;

    @FXML
    private Font x1;

    @FXML
    private Font x11;

    @FXML
    private Font x111;

    @FXML
    private Font x1111;

    @FXML
    private Font x12;

    @FXML
    void AgregarAnimal(ActionEvent event) {
        try {
            animal.setNombre_Animal(textoNombreAnimal.getText());
            animal.setTipo_Animal(textoTipoAnimal.getText());
            animal.setRaza_Animal(textoRazaAnimal.getText());
            
            
            CRUD.crearAnimal(animal, fnd.getID());
        } catch (Exception e) {
            System.out.println(e);
        }

        textoNombreAnimal.setText(null);
        textoTipoAnimal.setText(null);
        textoRazaAnimal.setText(null);
        if(animal.getFotoElegida() != null){
            vistaImagen.setImage(new Image(imgUrl));
        }
    }


    @FXML
    void InsertarFoto(ActionEvent event){
        imgUrl = vistaImagen.getImage().getUrl();
        this.animal.selectImage();
        try{
        vistaImagen.setImage(new Image("file:/" + animal.getRutaFotoElegida()));
        }catch(Exception e){
            System.out.println(e + "Ërror");
        }
    }

    void setFund(Fundacion fnd) {
        this.fnd = fnd;
        System.out.println(this.fnd.getNombre_Fun());
    }

}

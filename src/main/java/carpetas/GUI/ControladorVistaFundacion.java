package carpetas.GUI;

import carpetas.clases.Fundacion;
import carpetas.clases.Localidad;
import carpetas.sql_clases.CRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorVistaFundacion {

    private Fundacion fund;
    private Localidad local;

    @FXML
    private Button botonCambiarImagenFundacion;

    @FXML
    private Label correoElectronicoFundacion;

    @FXML
    private Label direccionFundacion;

    @FXML
    private ImageView imagenFundacion;

    @FXML
    private Label localidadFundacion;

    @FXML
    private Label nombreFundacion;

    @FXML
    private Label telefonoUsuario;

    @FXML
    void cambiarImagen(ActionEvent event) {
        fund.selectImage();
        imagenFundacion.setImage(new Image(fund.getRutaFotoElegida()));
        CRUD.updatePhotoFund(fund);
    }

    void setFund(Fundacion fund){
        this.fund = fund;
        this.local = CRUD.leerLocalidad(fund.getID_Localidad());

        nombreFundacion.setText(fund.getNombre_Fun());
        telefonoUsuario.setText(String.valueOf(fund.getTelefono_Fun()));
        direccionFundacion.setText(fund.getDireccion());
        correoElectronicoFundacion.setText(fund.getCorreo_Electronico_Fun());
        localidadFundacion.setText(local.getNombre_Loc());
        if(fund.getFotoMostrable() != null){
            imagenFundacion.setImage(new Image(fund.getFotoMostrable()));
        }

        
    }

}

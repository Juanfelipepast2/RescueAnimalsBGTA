package carpetas.GUI;

import java.io.IOException;

import carpetas.clases.Fundacion;
import carpetas.sql_clases.CRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControllerRegistroFundacion {

    public static Object ID_Localidad;

    @FXML
    private Button BtnCrearCuenta;

    @FXML
    private Button BtnVolver;

    @FXML
    private ChoiceBox<String> ChoiceLocalidad;

    @FXML
    private PasswordField TextClave;

    @FXML
    private TextField TextCorreo;

    @FXML
    private TextField TextDireccion;

    @FXML
    private TextField TextID;

    @FXML
    private TextField TextNombreFundacion;

    @FXML
    private PasswordField TextRepetirClave;

    @FXML
    private TextField TextTelefono;

    private Stage stage;

    ObservableList<String> Localidades = FXCollections.observableArrayList("1. Usaquén", "2. Chapinero", "3. Santa fé", "4. San Cristóbal", "5. Usme", "6. Tunjuelito", "7. Bosa", "8. Kennedy", "9. Fontibón", "10. Engativá", "11. Suba", "12. Barrios Unidos", "13. Teusaquillo", "14. Los Mártires", "15. Antonio Nariño", "16. Puente Aranda", "17. Candelaria", "18. Rafael Uribe Uribe", "19. Ciudad Bolívar", "20. Sumapaz");

    @FXML
    private void initialize() {
        ChoiceLocalidad.setItems(Localidades);
    }

    @FXML
    void CrearCuentaFunClic(ActionEvent event) throws IOException {
        //Crear cuenta revisando que el correo y el ID no exista en la base de datos
        int ID = Integer.parseInt(TextID.getText());
        System.out.println(ID);
        int ID_Localidad = EscogerValorChoiceBox();
        int Telefono_Fundacion = Integer.parseInt(TextTelefono.getText());
        Fundacion temp = new Fundacion(ID, ID_Localidad, TextNombreFundacion.getText(),TextDireccion.getText(),TextCorreo.getText(),TextClave.getText(),Telefono_Fundacion);
        if (CRUD.leerID(ID)==null && CRUD.leerCorreoFundacion(temp.getCorreo_Electronico_Fun())==null) {    
            if (TextClave.getText().equals(TextRepetirClave.getText())) {
                    CRUD.crearFundacion(temp);
                    AlertaInformacion("Registro Fundación", "La cuenta se ha creado correctamente");
                    cambiarVentana(event, temp);
                } else {
                    AlertaError("Registro Fundación", "Las contraseñas no coinciden");
                }
        } else {
            if(CRUD.leerID(ID)!=null){
                AlertaError("Registro Fundación", "La ID de fundación ingresada ya esta vinculada a una cuenta");
            }
            else if(CRUD.leerCorreoFundacion(TextCorreo.getText())!=null) {
                AlertaError("Registro Fundación", "El correo ingresado ya esta vinculado a una cuenta");
            }
        }
    }

    @FXML
    void AlertaInformacion(String Titulo, String Mensaje) {
        Alert AlertaInformacion = new Alert(AlertType.NONE, Mensaje, ButtonType.OK);
        AlertaInformacion.setTitle(Titulo);
        AlertaInformacion.showAndWait();
    }

    @FXML
    void AlertaError(String Titulo, String Mensaje) {
        Alert AlertaError = new Alert(AlertType.ERROR, Mensaje, ButtonType.OK);
        AlertaError.setTitle(Titulo);
        AlertaError.showAndWait();
    }

    @FXML
    private int EscogerValorChoiceBox(){
        switch(ChoiceLocalidad.getValue()){
            case "1. Usaquén":
            return 1;
            case "2. Chapinero":
            return 2;
            case "3. Santa fé":
            return 3;
            case "4. San Cristóbal":
            return 4;
            case "5. Usme":
            return 5;
            case "6. Tunjuelito":
            return 6;
            case "7. Bosa":
            return 7;
            case "8. Kennedy":
            return 8;
            case "9. Fontibón":
            return 9;
            case "10. Engativá":
            return 10;
            case "11. Suba":
            return 11;
            case "12. Barrios Unidos":
            return 12;
            case "13. Teusaquillo":
            return 13;
            case "14. Los Mártires":
            return 14;
            case "15. Antonio Nariño":
            return 15;
            case "16. Puente Aranda":
            return 16;
            case "17. Candelaria":
            return 17;
            case "18. Rafael Uribe Uribe":
            return 18;
            case "19. Ciudad Bolívar":
            return 19;
            case "20. Sumapaz":
            return 20;
        };
        return 0;
    }
    @FXML
    void volver(ActionEvent event) throws IOException {
        /*

        ESTE BLOQUE SOLO SE USA SI EL CONTROLADOR A USAR VA A RECIBIR INFORMACIÓN

        
        Parent root;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/carpetas/view/InicioDeSesionNormal.fxml"));
        root = loader.load();
        //ControllerInicioDeSesion controlInicio = loader.getController();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        */
        Main.setRoot("/carpetas/view/InicioDeSesionNormal");
    }

    void cambiarVentana(ActionEvent event, Fundacion fund) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/carpetas/view/Base_vista_fundacion.fxml"));
        Parent root;
        root = loader.load();

        ControladorBaseFundacion controlFund = new ControladorBaseFundacion();

        controlFund = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        controlFund.setFundacion(fund);

        stage.show();
    }

}
package carpetas.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import carpetas.sql_clases.Conexion;

public class VistaFundacionControlador {

    private ByteArrayOutputStream imagen;

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

        Connection conn = Conexion.getConnection();
        String consulta = "INSERT INTO ANIMAL(ID_Animal, ID_Fund, Cedula, Nombre_Ani, Tipo, Raza, FOTO_ANIMAL) VALUES (NULL,?, NULL, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(consulta);

            ps.setInt(1, 21);
            ps.setString(2, textoNombreAnimal.getText());
            ps.setString(3, textoTipoAnimal.getText());
            ps.setString(4, textoRazaAnimal.getText());
            ps.setBytes(5, imagen.toByteArray());
            
            ps.executeUpdate();

            conn.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("no" + e);
        }

    }

    @FXML
    void InsertarFoto(ActionEvent event) {
        try {

            FileChooser fc = new FileChooser();
            File archivoSeleccionado = fc.showOpenDialog(null);
            System.out.println(archivoSeleccionado);
            archivoSeleccionado.getAbsolutePath();
            int numrows = 0;

            FileInputStream fis = null;

            fis = new FileInputStream(archivoSeleccionado);
            System.out.println(fis);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int readnum = 0; (readnum = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, readnum);
            }

            fis.close();

            vistaImagen.setImage(new Image(archivoSeleccionado.getAbsolutePath()));

            imagen = bos;

        } catch (Exception er) {
            System.out.println("falle xd " + er);
        }

    }

}

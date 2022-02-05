package carpetas.GUI;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import carpetas.sql_clases.Conexion;

public class imageTest {

    @FXML
    private Button botonsito;

    @FXML
    private ImageView img;

    @FXML
    void changeImg(ActionEvent event) {

        //AHORA MISMO NO FUNCIONA DEBIDO A QUE NO HAY IMAGENES ALMACENADAS EN LA DB MOMENTANEAMENTE
        try {
            String query = "SELECT imagen FROM imagenUsuario WHERE id = 2";
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            InputStream is = rs.getBinaryStream("imagen");
            img.setImage(new Image(is));
        } catch (Exception e) {
            System.out.println(e + " XD");
        }
    }

    /*      ALGORITMO PARA INSERTAR IMAGENES EN LA BASE DE DATOS, ESTA COMENTADO PORQUE NO SE HA LOGRADO VER COMO ABRIR ARCHIVOS EN JAVAFX
    public static void insert() {
        try {
            int numrows = 0;
            FileInputStream fis;
            File photo = new File(
                    "ruta de archivo");
            fis = new FileInputStream(photo);
            System.out.println(fis);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int readnum = 0; (readnum = fis.read(buffer)) != -1;) {
                System.out.println(readnum);
                bos.write(buffer, 0, readnum);
            }

            fis.close();
            Connection conn = getConnection();
            PreparedStatement ps = conn
                    .prepareStatement("INSERT INTO tabla ejemplo (campo1, campo 2, campo 3) VALUES (1,1, ?)");
            ps.setBytes(1, bos.toByteArray());
            numrows = ps.executeUpdate();
            if (numrows > 0) {
                System.out.println("data addded");
            }
            ps.close();
            conn.close();

        } catch (Exception er) {
            System.out.println("falle xd " + er);
        }
    }
    */

}

package carpetas.sql_clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            String url = "BaseDeDatos.db"; 
            conn = DriverManager.getConnection("jdbc:sqlite::resource:" + url);
            System.out.println("Conexion exitosa.");
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos/n" + ex.getMessage());
            return null;
        }
        return conn;
    }
}

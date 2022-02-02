package carpetas.clases;

import java.sql.Connection;

import carpetas.sql_clases.*;

public class App {
    public static void main(String[] args) throws Exception {
        Connection con = null;
        con = Conexion.getConnection();
        con.close();
    }
}

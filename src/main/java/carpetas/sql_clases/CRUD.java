package carpetas.sql_clases;

import java.sql.*;

import carpetas.sql_clases.*;
import carpetas.clases.*;



public class CRUD {
    //Crear usuario
    public static void crearUsuario(Usuario Usuario) {
        try {
            Connection conexion = Conexion.getConnection();
            String sql = "INSERT INTO USUARIO (Cedula, Nickname, Nombre, Apellido, Correo_Electronico_Usu, Contrasena_Usu, Telefono_Usu, FOTO_PERFIL) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, Usuario.getCedula());
            ps.setString(2, Usuario.getUsername());
            ps.setString(3, Usuario.getNombre());
            ps.setString(4, Usuario.getApellido());
            ps.setString(5, Usuario.getCorreo());
            ps.setString(6, Usuario.getContraseña());
            ps.setInt(7, Usuario.getNumeroTelefonico());
            ps.setBytes(8, Usuario.getFoto());
            ps.execute();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Usuario leerUsuario(String Nickname) {
        //Leer usuario
        Usuario Usuario = new Usuario();
        try {
            Connection conexion = Conexion.getConnection();
            String sql = "SELECT * FROM USUARIO WHERE Nickname = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            //ps.setString(1, Usuario.getUsername());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario.setCedula(rs.getInt("Cedula"));
                Usuario.setUsername(rs.getString("Nickname"));
                Usuario.setNombre(rs.getString("Nombre"));
                Usuario.setApellido(rs.getString("Apellido"));
                Usuario.setCorreo(rs.getString("Correo_Electronico_Usu"));
                Usuario.setContraseña(rs.getString("Contrasena_Usu"));
                Usuario.setNumeroTelefonico(rs.getInt("Telefono_Usu"));
                //Usuario.setFoto(rs.getBinaryStream("FOTO_PERFIL"));
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }   return Usuario;
    }
}

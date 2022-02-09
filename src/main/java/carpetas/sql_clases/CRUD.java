package carpetas.sql_clases;

import java.sql.*;
import java.util.ArrayList;

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
            ps.setBytes(8, null);
            ps.execute();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Usuario leerUsuario(String correo) {
        //Leer usuario
        Usuario Usuario = null;
        try {
            Connection conexion = Conexion.getConnection();
            String sql = "SELECT * FROM USUARIO WHERE Correo_Electronico_Usu = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario = new Usuario();
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
            /*e.printStackTrace()*/System.out.println("el correo no es usado por un usuario");
            
        }   return Usuario;
    }

    public static Fundacion leerFundacion(String correo) {
        //Leer usuario
        Fundacion fundacion = null;
        try {
            Connection conexion = Conexion.getConnection();
            String sql = "SELECT * FROM FUNDACION WHERE Correo_Electronico_Fun = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fundacion = new Fundacion();
                fundacion.setID(rs.getInt("ID_Fund"));
                fundacion.setID_Localidad(rs.getInt("ID_Localidad"));
                fundacion.setNombre_Fun(rs.getString("Nombre_Fun"));
                fundacion.setDireccion(rs.getString("Direccion"));
                fundacion.setCorreo_Electronico_Fun(rs.getString("Correo_Electronico_Fun"));
                fundacion.setContrasena_Fun(rs.getString("Contrasena_Fun"));
                fundacion.setTelefono_Fun(rs.getInt("Telefono_Fun"));
                
                //Usuario.setFoto(rs.getBinaryStream("FOTO_PERFIL"));
            }
            conexion.close();
        } catch (SQLException e) {
            /*e.printStackTrace()*/System.out.println("el correo no es usado por una fundacion");
        }   return fundacion;
    }

    public static ArrayList<Animal> LeerAnimales(){
        Connection conn = Conexion.getConnection();
        ArrayList<Animal> animales = new ArrayList<>();
        String sql = "SELECT * FROM ANIMAL";
        try{
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery(sql);
            while(rs.next()){
                Animal animal = new Animal();
                animal.setID_Animal(rs.getInt(1));
                animal.setID_Fund(rs.getInt(2));
                animal.setNombre_Animal(rs.getString(4));
                animal.setTipo_Animal(rs.getString(5));
                animal.setRaza_Animal(rs.getString(6));
                animales.add(animal);
            }
            conn.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return animales;
    }

    
}

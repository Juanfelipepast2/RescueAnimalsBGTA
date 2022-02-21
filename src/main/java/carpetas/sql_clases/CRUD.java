package carpetas.sql_clases;

import java.sql.*;
import java.util.ArrayList;

import carpetas.clases.*;

public class CRUD {
    // Crear usuario
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

    public static Usuario leerCorreo(String correo) {
        // Leer usuario
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
                Usuario.setFotoMostrable(rs.getBinaryStream("FOTO_PERFIL"));
            }
            conexion.close();
        } catch (SQLException e) {
            /* e.printStackTrace() */System.out.println("El correo no es usado por un usuario");

        }
        return Usuario;
    }

    public static Usuario leerCedula(int Cedula) {
        // Leer usuario
        Usuario Usuario = null;
        try {
            Connection conexion = Conexion.getConnection();
            String sql = "SELECT * FROM USUARIO WHERE Cedula = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, Cedula);
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
                Usuario.setFotoMostrable(rs.getBinaryStream("FOTO_PERFIL"));
            }
            conexion.close();
        } catch (SQLException e) {
            /* e.printStackTrace() */System.out.println("El correo no es usado por un usuario");

        }
        return Usuario;
    }

    public static Usuario leerUsuario(String username) {
        // Leer usuario
        Usuario Usuario = null;
        try {
            Connection conexion = Conexion.getConnection();
            String sql = "SELECT * FROM USUARIO WHERE Nickname = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, username);
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
                Usuario.setFotoMostrable(rs.getBinaryStream("FOTO_PERFIL"));
            }
            conexion.close();
        } catch (SQLException e) {
            /* e.printStackTrace() */System.out.println("El nombre de usuario no es usado por un usuario");

        }
        return Usuario;
    }

    public static Fundacion leerCorreoFundacion(String correo) {
        // Leer usuario
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
                fundacion.setFotoMostrable(rs.getBinaryStream("FOTO_FUNDACION"));

            }
            conexion.close();
        } catch (SQLException e) {
            /* e.printStackTrace() */System.out.println("El correo no es usado por una fundación");
        }
        return fundacion;
    }

    public static Fundacion leerID(int ID) {
        // Leer Cedula
        Fundacion Fundacion = null;
        try {
            Connection conexion = Conexion.getConnection();
            String sql = "SELECT * FROM FUNDACION WHERE ID_Fund = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fundacion = new Fundacion();
                Fundacion.setID(rs.getInt("ID_Fund"));
                Fundacion.setID_Localidad(rs.getInt("ID_Localidad"));
                Fundacion.setNombre_Fun(rs.getString("Nombre_Fun"));
                Fundacion.setDireccion(rs.getString("Direccion"));
                Fundacion.setCorreo_Electronico_Fun(rs.getString("Correo_Electronico_Fun"));
                Fundacion.setContrasena_Fun(rs.getString("Contrasena_Fun"));
                Fundacion.setTelefono_Fun(rs.getInt("Telefono_Fun"));
                Fundacion.setFotoMostrable(rs.getBinaryStream("FOTO_FUNDACION"));
            }
            conexion.close();
        } catch (SQLException e) {
            /* e.printStackTrace() */System.out.println("El correo no es usado por una fundación");
        }
        return Fundacion;
    }

    public static Localidad leerLocalidad(int ID) {
        Localidad local = null;
        String query = "SELECT * FROM LOCALIDAD WHERE ID_Localidad=?";
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                local = new Localidad();
                local.setID_Localidad(rs.getInt(1));
                local.setNombre_Loc(rs.getString(2));
            }
            conn.close();
        } catch (SQLException e) {

        }

        return local;
    }

    public static Animal leerAnimal(int IDAnimal) {
        Animal animal = null;
        String query = "SELECT ID_Animal, ANIMAL.ID_Fund, Nombre_Ani, Tipo, Raza, FOTO_ANIMAL, Nombre_Fun FROM ANIMAL, FUNDACION WHERE ANIMAL.ID_Fund == FUNDACION.ID_Fund and ID_ANIMAL = ?";
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, IDAnimal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                animal = new Animal();
                animal.setID_Animal(rs.getInt("ID_Animal"));
                animal.setNombre_Animal(rs.getString("Nombre_Ani"));                
                animal.setID_Fund(rs.getInt("ID_Fund"));
                animal.setNombre_Fund(rs.getString("Nombre_Fun"));
                animal.setTipo_Animal(rs.getString("Tipo"));
                animal.setRaza_Animal(rs.getString("Raza"));
                animal.setFotoMostrable(rs.getBytes("FOTO_ANIMAL"));

            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return animal;
    }

    public static void crearFundacion(Fundacion Fundacion) {
        try {
            Connection conexion = Conexion.getConnection();
            String sql = "INSERT INTO FUNDACION (ID_Fund, ID_Localidad, Nombre_Fun, Direccion, Correo_Electronico_Fun, Contrasena_Fun, Telefono_Fun, FOTO_FUNDACION) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, Fundacion.getID());
            ps.setInt(2, Fundacion.getID_Localidad());
            ps.setString(3, Fundacion.getNombre_Fun());
            ps.setString(4, Fundacion.getDireccion());
            ps.setString(5, Fundacion.getCorreo_Electronico_Fun());
            ps.setString(6, Fundacion.getContrasena_Fun());
            ps.setInt(7, Fundacion.getTelefono_Fun());
            ps.setBytes(8, null);
            ps.execute();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Animal> LeerAnimales() {
        Connection conn = Conexion.getConnection();
        ArrayList<Animal> animales = new ArrayList<>();
        String sql = "SELECT ID_Animal, ANIMAL.ID_Fund, Nombre_Ani, Tipo, Raza, FOTO_ANIMAL, Nombre_Fun FROM ANIMAL, FUNDACION WHERE ANIMAL.ID_Fund == FUNDACION.ID_Fund";
        try {
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery(sql);
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setID_Animal(rs.getInt("ID_Animal"));
                animal.setID_Fund(rs.getInt("ID_Fund"));
                animal.setNombre_Animal(rs.getString("Nombre_Ani"));
                animal.setTipo_Animal(rs.getString("Tipo"));
                animal.setRaza_Animal(rs.getString("Raza"));
                animal.setNombre_Fund(rs.getString("Nombre_Fun"));
                animal.setFotoMostrable(rs.getBytes("FOTO_ANIMAL"));
                animales.add(animal);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }
        return animales;
    }

    public static ArrayList<Animal> LeerAnimalesIDFundacion(int IdFund) {
        Connection conn = Conexion.getConnection();
        ArrayList<Animal> animales = new ArrayList<>();
        String sql = "SELECT ID_Animal, ANIMAL.ID_Fund, Nombre_Ani, Tipo, Raza, FOTO_ANIMAL  FROM ANIMAL  WHERE ANIMAL.ID_Fund = "
                + IdFund;
        try {
            Statement sm = conn.createStatement();

            ResultSet rs = sm.executeQuery(sql);
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setID_Animal(rs.getInt("ID_Animal"));
                animal.setID_Fund(rs.getInt("ID_Fund"));
                animal.setNombre_Animal(rs.getString("Nombre_Ani"));
                animal.setTipo_Animal(rs.getString("Tipo"));
                animal.setRaza_Animal(rs.getString("Raza"));
                ;
                animal.setFotoMostrable(rs.getBytes("FOTO_ANIMAL"));
                animales.add(animal);
            }
            conn.close();
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return animales;
    }

    public static ArrayList<Animal> LeerAnimalesCedula(int Cedula) {
        Connection conn = Conexion.getConnection();
        ArrayList<Animal> animales = new ArrayList<>();
        String sql = "SELECT ID_Animal, ANIMAL.ID_Fund, Nombre_Ani, Tipo, Raza, FOTO_ANIMAL FROM ANIMAL WHERE ANIMAL.Cedula = "
                + Cedula;
        try {
            Statement sm = conn.createStatement();

            ResultSet rs = sm.executeQuery(sql);
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setID_Animal(rs.getInt("ID_Animal"));
                animal.setID_Fund(rs.getInt("ID_Fund"));
                animal.setNombre_Animal(rs.getString("Nombre_Ani"));
                animal.setTipo_Animal(rs.getString("Tipo"));
                animal.setRaza_Animal(rs.getString("Raza"));
                animal.setFotoMostrable(rs.getBytes("FOTO_ANIMAL"));
                animales.add(animal);
            }
            conn.close();
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return animales;
    }

    public static void updatePhotoUser(Usuario user) {
        Connection conn = Conexion.getConnection();
        String query = "UPDATE USUARIO SET FOTO_PERFIL = ? WHERE Cedula = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setBytes(1, user.getFotoElegida());
            ps.setInt(2, user.getCedula());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void updatePhotoFund(Fundacion fund) {
        Connection conn = Conexion.getConnection();
        String query = "UPDATE FUNDACION SET FOTO_FUNDACION = ? WHERE ID_Fund = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setBytes(1, fund.getFotoElegida());
            ps.setInt(2, fund.getID_Fundacion());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void updateAnimalAdoptado(Usuario usr, int ID_Animal) {
        Connection conn = Conexion.getConnection();
        String query = "UPDATE ANIMAL SET Cedula = ?, ID_Fund = NULL WHERE ID_Animal = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, usr.getCedula());
            ps.setInt(2, ID_Animal);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void crearAnimal(Animal animal, int fnd_id) {

        Connection conn = Conexion.getConnection();
        String consulta = "INSERT INTO ANIMAL(ID_Animal, ID_Fund, Cedula, Nombre_Ani, Tipo, Raza, FOTO_ANIMAL) VALUES (NULL,?, NULL, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(consulta);

            ps.setInt(1, fnd_id);
            ps.setString(2, animal.getNombre_Animal());
            ps.setString(3, animal.getTipo_Animal());
            ps.setString(4, animal.getRaza_Animal());
            ps.setBytes(5, animal.getFotoElegida());

            ps.executeUpdate();

            conn.close();

        } catch (Exception e) {
            // System.out.println("no ");
            e.printStackTrace();
        }

    }

}

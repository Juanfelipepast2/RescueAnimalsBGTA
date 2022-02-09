package carpetas.clases;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;

import javafx.stage.FileChooser;

public class Usuario {
    private int cedula;
    private String username;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String correo;
    private int numeroTelefonico;
    
    private byte[] fotoElegida;
    private String rutaFotoElegida;
    private InputStream fotoMostrable;
    


    public Usuario(int cedula, String username, String nombre, String apellido, String contraseña, String correo,
            int numeroTelefonico) {
        this.cedula = cedula;
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.correo = correo;
        this.numeroTelefonico = numeroTelefonico;
    }

    public Usuario() {
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(int numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    

    public void selectImage() {

        FileChooser fc = new FileChooser();
        File archivoSeleccionado = fc.showOpenDialog(null);
        System.out.println(archivoSeleccionado);
        archivoSeleccionado.getAbsolutePath();

        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;

        try {
            fis = new FileInputStream(archivoSeleccionado);

            System.out.println(fis);
            bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int readnum = 0; (readnum = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, readnum);
            }
            rutaFotoElegida = archivoSeleccionado.getAbsolutePath();
            fis.close();
            
        } catch (Exception e) {
            // En caso de que el archivo no sea encontrado
            e.printStackTrace();
        }
        fotoElegida = bos.toByteArray();
    
        
        
    }


    public InputStream getFotoMostrable(){
        return fotoMostrable;
    }

    public void setFotoMostrable(InputStream fotoMostrable){
        this.fotoMostrable = fotoMostrable;
    }

    public byte[] getFotoElegida() {
        return fotoElegida;
    }

    public void setFotoElegida(byte[] fotoElegida){
        this.fotoElegida = fotoElegida;
    }

    public String getRutaFotoElegida() {
        return rutaFotoElegida;
    }

    public void setRutaFotoElegida(String rutaFotoElegida) {
        this.rutaFotoElegida = rutaFotoElegida;
    }

    

}
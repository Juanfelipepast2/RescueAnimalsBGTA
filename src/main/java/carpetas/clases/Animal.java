package carpetas.clases;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;


import javafx.stage.FileChooser;

public class Animal{
    //Get and set Nombre_Animal, ID_Cliente, ID_Animal, Fecha_Nacimiento, Fecha_Ingreso, Fecha_Ultima_Desparacitacion
    // prueba comentario
    private String Nombre_Animal;
    private int ID_Cliente;
    private int ID_Animal;
    private int ID_Fund;
    private String nombre_Fund;
    private String tipo_Animal;
    private String raza_Animal;

    private byte[] fotoElegida;
    private String rutaFotoElegida;
    private ByteArrayInputStream fotoMostrable;

    


    //Constructor

    
    public Animal(String nombre_Animal, int iD_Cliente, int iD_Animal, int iD_Fund, String nombre_Fund,
            String tipo_Animal, String raza_Animal) {
        Nombre_Animal = nombre_Animal;
        ID_Cliente = iD_Cliente;
        ID_Animal = iD_Animal;
        ID_Fund = iD_Fund;
        this.nombre_Fund = nombre_Fund;
        this.tipo_Animal = tipo_Animal;
        this.raza_Animal = raza_Animal;
    }

    public Animal() {
    }

    //Metodos


    public String getNombre_Animal() {
        return Nombre_Animal;
    }

    public void setNombre_Animal(String nombre_Animal) {
        Nombre_Animal = nombre_Animal;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int iD_Cliente) {
        ID_Cliente = iD_Cliente;
    }

    public int getID_Animal() {
        return ID_Animal;
    }

    public void setID_Animal(int iD_Animal) {
        ID_Animal = iD_Animal;
    }

    public int getID_Fund() {
        return ID_Fund;
    }

    public void setID_Fund(int iD_Fund) {
        ID_Fund = iD_Fund;
    }

    public String getNombre_Fund() {
        return nombre_Fund;
    }

    public void setNombre_Fund(String nombre_Fund) {
        this.nombre_Fund = nombre_Fund;
    }

    public String getTipo_Animal() {
        return tipo_Animal;
    }

    public void setTipo_Animal(String tipo_Animal) {
        this.tipo_Animal = tipo_Animal;
    }

    public String getRaza_Animal() {
        return raza_Animal;
    }

    public void setRaza_Animal(String raza_Animal) {
        this.raza_Animal = raza_Animal;
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


    public ByteArrayInputStream getFotoMostrable(){
        return fotoMostrable;
    }

    public void setFotoMostrable(byte[] fotoMostrable){
        this.fotoMostrable = new ByteArrayInputStream(fotoMostrable);
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
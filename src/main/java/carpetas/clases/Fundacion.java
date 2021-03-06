package carpetas.clases;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javafx.stage.FileChooser;

public class Fundacion {


  private String rutaFotoElegida;
  private byte[] fotoElegida;
  private InputStream fotoMostrable;

  private int ID_Fundacion;
  private int ID_Localidad;
  private String Nombre_Fun;
  private String Direccion;
  private String Correo_Electronico_Fun;
  private String Contrasena_Fun;
  private int Telefono_Fun;

  public Fundacion(int _ID_Fundacion, int _ID_Localidad, String _Nombre_Fun, String _Direccion,
      String _Correo_Electronico_Fun, String _Contrasena_Fun, int _Telefono_Fun) {
    this.ID_Fundacion = _ID_Fundacion;
    this.ID_Localidad = _ID_Localidad;
    this.Nombre_Fun = _Nombre_Fun;
    this.Direccion = _Direccion;
    this.Correo_Electronico_Fun = _Correo_Electronico_Fun;
    this.Contrasena_Fun = _Contrasena_Fun;
    this.Telefono_Fun = _Telefono_Fun;
  }

  public Fundacion() {
  }

  public int getID() {
    return this.ID_Fundacion;
  }

  public void setID(int _ID_Fundacion) {
    this.ID_Fundacion = _ID_Fundacion;
  }

  public int getID_Localidad() {
    return ID_Localidad;
  }

  public void setID_Localidad(int iD_Localidad) {
    ID_Localidad = iD_Localidad;
  }

  public String getNombre_Fun() {
    return this.Nombre_Fun;
  }

  public void setNombre_Fun(String _Nombre_Fun) {
    this.Nombre_Fun = _Nombre_Fun;
  }

  public String getDireccion() {
    return this.Direccion;
  }

  public void setDireccion(String _Direccion) {
    this.Direccion = _Direccion;
  }

  public String getCorreo_Electronico_Fun() {
    return this.Correo_Electronico_Fun;
  }

  public void setCorreo_Electronico_Fun(String _Correo_Electronico_Fun) {
    this.Correo_Electronico_Fun = _Correo_Electronico_Fun;
  }

  public String getContrasena_Fun() {
    return this.Contrasena_Fun;
  }

  public void setContrasena_Fun(String _Contrasena_Fun) {
    this.Contrasena_Fun = _Contrasena_Fun;
  }

  public int getTelefono_Fun() {
    return this.Telefono_Fun;
  }

  public void setTelefono_Fun(int _Telefono_Fun) {
    this.Telefono_Fun = _Telefono_Fun;
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

  public String getRutaFotoElegida() {
    return rutaFotoElegida;
  }

  public void setRutaFotoElegida(String rutaFotoElegida) {
    this.rutaFotoElegida = rutaFotoElegida;
  }

  public byte[] getFotoElegida() {
    return fotoElegida;
  }

  public void setFotoElegida(byte[] fotoElegida) {
    this.fotoElegida = fotoElegida;
  }

  public InputStream getFotoMostrable() {
    return fotoMostrable;
  }

  public void setFotoMostrable(InputStream fotoMostrable) {
    this.fotoMostrable = fotoMostrable;
  }

  public int getID_Fundacion() {
    return ID_Fundacion;
  }

  public void setID_Fundacion(int iD_Fundacion) {
    ID_Fundacion = iD_Fundacion;
  }
  
}
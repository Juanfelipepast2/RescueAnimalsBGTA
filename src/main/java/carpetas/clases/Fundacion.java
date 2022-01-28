package carpetas.clases;
public class Fundacion{

  private int ID_Fundacion;
  private String Nombre_Fun;
  private String Direccion;
  private String Correo_Electronico_Fun;
  private String Contrasena_Fun;
  private int Telefono_Fun;

  public Fundacion(int _ID_Fundacion,String _Nombre_Fun,String _Direccion,String _Correo_Electronico_Fun,String _Contrasena_Fun,int _Telefono_Fun){
    this.ID_Fundacion = _ID_Fundacion;
    this.Nombre_Fun = _Nombre_Fun;
    this.Direccion = _Direccion;
    this.Correo_Electronico_Fun =_Correo_Electronico_Fun;
    this.Contrasena_Fun = _Contrasena_Fun;
    this.Telefono_Fun = _Telefono_Fun;
  }

  public int getID(){
    return this.ID_Fundacion;
  }
  public void setID(int _ID_Fundacion){
    this.ID_Fundacion = _ID_Fundacion;
  }

  public String getNombre_Fun(){
    return this.Nombre_Fun;
  }
  public void setNombre_Fun(String _Nombre_Fun){
    this.Nombre_Fun = _Nombre_Fun;
  }

  public String getDireccion(){
    return this.Direccion;
  }
  public void setDireccion(String _Direccion){
    this.Direccion = _Direccion;
  }

  public String getCorreo_Electronico_Fun(){
    return this.Correo_Electronico_Fun;
  }
    public void setCorreo_Electronico_Fun(String _Correo_Electronico_Fun){
    this.Correo_Electronico_Fun = _Correo_Electronico_Fun;
  }

  public String getContrasena_Fun(){
    return this.Contrasena_Fun;
  }
  public void setContrasena_Fun(String _Contrasena_Fun){
    this.Contrasena_Fun = _Contrasena_Fun;
  }

  public int getTelefono_Fun(){
    return this.Telefono_Fun;
  }
  public void setTelefono_Fun(int _Telefono_Fun){
    this.Telefono_Fun = _Telefono_Fun;
  }
}
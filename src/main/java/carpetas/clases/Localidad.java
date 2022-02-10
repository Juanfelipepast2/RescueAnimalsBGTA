package carpetas.clases;
public class Localidad{

  private int ID_Localidad;
  private String Nombre_Loc;

  public Localidad(int _ID_Localidad,String _Nombre_Loc){
    this.ID_Localidad = _ID_Localidad;
    this.Nombre_Loc = _Nombre_Loc;
  }

  public Localidad(){}

  public int getID_Localidad(){
    return this.ID_Localidad;
  }
  public void setID_Localidad(int _ID_Localidad){
    this.ID_Localidad = _ID_Localidad;
  }

  public String getNombre_Loc(){
    return this.Nombre_Loc;
  }
  public void setNombre_Loc(String _Nombre_Loc){
    this.Nombre_Loc = _Nombre_Loc;
  }
}
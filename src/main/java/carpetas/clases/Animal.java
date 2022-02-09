package carpetas.clases;
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

    
}
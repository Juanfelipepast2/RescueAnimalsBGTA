public class Animal{
    //Get and set Nombre_Animal, ID_Cliente, ID_Animal, Fecha_Nacimiento, Fecha_Ingreso, Fecha_Ultima_Desparacitacion
    private String Nombre_Animal;
    private int ID_Cliente;
    private int ID_Animal;
    private String Fecha_Nacimiento;
    private String Fecha_Ingreso;

    public String getNombre_Animal() {
        return Nombre_Animal;
    }

    public void setNombre_Animal(String Nombre_Animal) {
        this.Nombre_Animal = Nombre_Animal;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public int getID_Animal() {
        return ID_Animal;
    }

    public void setID_Animal(int ID_Animal) {
        this.ID_Animal = ID_Animal;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }  

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getFecha_Ingreso() {
        return Fecha_Ingreso;
    }   

    public void setFecha_Ingreso(String Fecha_Ingreso) {
        this.Fecha_Ingreso = Fecha_Ingreso;
    }

    public String getFecha_Ultima_Desparacitacion() {
        return Fecha_Ultima_Desparacitacion;
    }

    public void setFecha_Ultima_Desparacitacion(String Fecha_Ultima_Desparacitacion) {
        this.Fecha_Ultima_Desparacitacion = Fecha_Ultima_Desparacitacion;
    }

    private String Fecha_Ultima_Desparacitacion;

    //Constructor

    public Animal(String Nombre_Animal, int ID_Cliente, int ID_Animal, String Fecha_Nacimiento, String Fecha_Ingreso, String Fecha_Ultima_Desparacitacion) {
        this.Nombre_Animal = Nombre_Animal;
        this.ID_Cliente = ID_Cliente;
        this.ID_Animal = ID_Animal;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Fecha_Ingreso = Fecha_Ingreso;
        this.Fecha_Ultima_Desparacitacion = Fecha_Ultima_Desparacitacion;
    }

    public Animal() {
    }

    //Metodos

    public void desparacitar(){
        System.out.println("Se ha desparacitado el animal");
    }

    public void vacunar(){
        System.out.println("Se ha vacunado el animal");
    }

    public void alimentar(){
        System.out.println("Se ha alimentado el animal");
    }
}
package carpetas.clases;


public class Usuario{
    int cedula;
    String username;
    String nombre;
    String apellido;
    String contraseña;
    String correo;
    int numeroTelefonico;
    byte[] foto;
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

    public Usuario(){}
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
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public byte[] getFoto() {
        return foto;
    }

}
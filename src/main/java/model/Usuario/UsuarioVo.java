package model.Usuario;

public class UsuarioVo {
    
    //Atributos
    private int idUsuario;
    private String nombre;
    private String apellido;
    private int telefono;
    private int edad;
    private String estado;
    private String nombreUsuario;
    private String contraseña;
    
    //Metodos Constructores 
    public UsuarioVo(){}

    public UsuarioVo(int idUsuario, String nombre, String apellido, int telefono, int edad, String estado, String nombreUsuario,
            String contraseña) {
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.estado = estado;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }
    
    //Metodos Accesores
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
    

}

package com.example.loginbmp;

public class Usuario {
    int Id;
    String Usuario, Nombre, Apellidos, Email, Password;

    //Método constructor de la clase usuario
    public Usuario() {
    }

    //Método constructor para inicializar los atributos
    public Usuario(String usuario, String nombre, String apellidos, String email, String password) {
        Usuario = usuario;
        Nombre = nombre;
        Apellidos = apellidos;
        Email = email;
        Password = password;
    }

    //Método para validar si están vacios los campos
    public boolean isNull(){
        if (Usuario.equals("")&&Nombre.equals("")&&Apellidos.equals("")&&Email.equals("")&&Password.equals("")){
            return false;
        }else{
            return true;
        }
    }

    //Método toString que permite imprimir los datos de clase
    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", Usuario='" + Usuario + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    //Getter and Setter de cada atributo
    //Setter es para establecer un parametro
    //Getter es para mostrar el parametro
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}


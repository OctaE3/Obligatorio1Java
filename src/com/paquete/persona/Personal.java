package com.paquete.persona;

public class Personal {
    private String _nombre;
    private String _apellido;
    private byte _edad;

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public byte get_edad() {
        return _edad;
    }

    public void set_edad(byte _edad) {
        this._edad = _edad;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "Nombre: '" + _nombre + '\'' +
                ", Apellido: '" + _apellido + '\'' +
                ", Edad: " + _edad +
                '}';
    }

    public Personal(){};

    public Personal(String pNombre, String pApellido, byte pEdad) {
        this._nombre = pNombre;
        this._apellido = pApellido;
        this._edad = pEdad;
    }
}

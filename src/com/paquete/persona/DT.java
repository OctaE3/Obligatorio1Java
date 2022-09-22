package com.paquete.persona;

public class DT extends Personal{

    @Override
    public String toString() {
        return "DT{}";
    }

    public DT(){};

    public DT(String pNombre, String pApellido, byte pEdad) {
        super(pNombre, pApellido, pEdad);
    }
}

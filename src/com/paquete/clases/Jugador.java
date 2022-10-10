package com.paquete.clases;

public class Jugador extends Personal{
    private String _puesto;
    private byte _numero;

    private int _gol;

    public String get_puesto() {
        return _puesto;
    }

    public void set_puesto(String _puesto) {
        this._puesto = _puesto;
    }

    public byte get_numero() {
        return _numero;
    }

    public int get_gol() {
        return _gol;
    }

    public void set_gol(int _gol) {
        this._gol = _gol;
    }

    public void set_numero(byte _numero) {
        this._numero = _numero;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Puesto: '" + _puesto + '\'' +
                ", Numero: " + _numero;
    }

    public Jugador(){};

    public Jugador(String pNombre, String pApellido, byte pEdad, String pPuesto, byte pNumero, int pGol) {
        super(pNombre, pApellido, pEdad);
        this._puesto = pPuesto;
        this._numero = pNumero;
        this._gol =pGol;
    }
}

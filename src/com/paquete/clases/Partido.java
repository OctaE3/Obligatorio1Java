package com.paquete.clases;

public class Partido {
    private String _estadio;
    private String _dia;
    private String _hora;
    private String _clima;
    private String _minutosJugados;

    public String get_estadio() {
        return _estadio;
    }

    public void set_estadio(String _estadio) {
        this._estadio = _estadio;
    }

    public String get_dia() {
        return _dia;
    }

    public void set_dia(String _dia) {
        this._dia = _dia;
    }

    public String get_hora() {
        return _hora;
    }

    public void set_hora(String _hora) {
        this._hora = _hora;
    }

    public String get_clima() {
        return _clima;
    }

    public void set_clima(String _clima) {
        this._clima = _clima;
    }

    public String get_minutosJugados() {
        return _minutosJugados;
    }

    public void set_minutosJugados(String _minutosJugados) {
        this._minutosJugados = _minutosJugados;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "_estadio='" + _estadio + '\'' +
                ", _dia='" + _dia + '\'' +
                ", _hora='" + _hora + '\'' +
                ", _clima='" + _clima + '\'' +
                ", _minutosJugados='" + _minutosJugados + '\'' +
                '}';
    }

    public  Partido() { }

    public Partido(String Estadio, String Dia, String Hora, String Clima, String MinutosJugados) {
        this._estadio = Estadio;
        this._dia = Dia;
        this._hora = Hora;
        this._clima = Clima;
        this._minutosJugados = MinutosJugados;
    }
}

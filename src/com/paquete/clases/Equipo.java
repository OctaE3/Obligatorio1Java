package com.paquete.clases;
import java.util.List;

public class Equipo {
    private byte _id;
    private String _nombre;
    private List<Jugador> _listaTitulares;
    private List<Jugador> _listaSuplentes;
    private DT _tecnico;

    public byte get_id() {
        return _id;
    }

    public void set_id(byte _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public List<Jugador> get_listaTitulares() {
        return _listaTitulares;
    }

    public void set_listaTitulares(List<Jugador> _listaTitulares) {
        this._listaTitulares = _listaTitulares;
    }

    public List<Jugador> get_listaSuplentes() {
        return _listaSuplentes;
    }

    public void set_listaSuplentes(List<Jugador> _listaSuplentes) {
        this._listaSuplentes = _listaSuplentes;
    }

    public DT get_tecnico() {
        return _tecnico;
    }

    public void set_tecnico(DT _tecnico) {
        this._tecnico = _tecnico;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "_id=" + _id +
                ", _nombre='" + _nombre + '\'' +
                ", _listaTitulares=" + _listaTitulares +
                ", _listaSuplentes=" + _listaSuplentes +
                ", _tecnico=" + _tecnico +
                '}';
    }

    public Equipo() { }

    public Equipo(byte Id, String Nombre, List<Jugador> ListaTitulares, List<Jugador> ListaSuplentes, DT Tecnico) {
        this._id = Id;
        this._nombre = Nombre;
        this._listaTitulares = ListaTitulares;
        this._listaSuplentes = ListaSuplentes;
        this._tecnico = Tecnico;
    }
}

package co.com.sofka.sofkabook.domain.Publicaciones.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public class CreateMensaje implements Command {

    private final IdMensajes idMensajes;
    private final Titulo titulo;
    private final Fecha fecha;
    private final Name name;
    private final IdGrupo idGrupo;

    public CreateMensaje(IdMensajes idMensajes, Titulo titulo, Fecha fecha, Name name, IdGrupo idGrupo) {
        this.idMensajes = idMensajes;
        this.titulo = titulo;
        this.fecha = fecha;
        this.name = name;
        this.idGrupo = idGrupo;
    }

    public IdMensajes IdMensajes() {
        return idMensajes;
    }

    public Titulo Titulo() {
        return titulo;
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Name Name() {
        return name;
    }

    public IdGrupo IdGrupo() {
        return idGrupo;
    }
}

package co.com.sofka.sofkabook.domain.Publicaciones.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Fecha;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdGrupo;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Titulo;

public class CreateGrupo implements Command {
    private final IdGrupo idGrupo;
    private final Titulo titulo;
    private final Fecha fecha;
    private final Name name;

    public CreateGrupo(IdGrupo idGrupo, Titulo titulo, Fecha fecha, Name name) {
        this.idGrupo = idGrupo;
        this.titulo = titulo;
        this.fecha = fecha;
        this.name = name;
    }

    public IdGrupo IdGrupo() {
        return idGrupo;
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
}

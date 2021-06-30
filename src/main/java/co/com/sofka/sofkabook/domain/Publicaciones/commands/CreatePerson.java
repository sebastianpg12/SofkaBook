package co.com.sofka.sofkabook.domain.Publicaciones.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public class CreatePerson implements Command {
    private final IdUsuario idUsuario;
    private final Email email;
    private final Name name;
    private final Fecha fecha;

    public CreatePerson(IdUsuario idUsuario, Email email, Name name, Fecha fecha) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.name = name;
        this.fecha = fecha;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Email getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public Fecha getFecha() {
        return fecha;
    }
}

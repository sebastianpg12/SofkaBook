package co.com.sofka.sofkabook.domain.Publicaciones.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Email;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdUsuario;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Image;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;

public class GetPersons implements Command {
    private final IdUsuario idUsuario;


    public GetPersons(IdUsuario idUsuario) {
        this.idUsuario = idUsuario;

    }

    public IdUsuario IdUsuario() {
        return idUsuario;
    }


}

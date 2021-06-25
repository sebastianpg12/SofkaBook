package co.com.sofka.sofkabook.domain.Publicaciones.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Email;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdUsuario;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Image;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;

public class PersonsGot extends DomainEvent {

    private final IdUsuario idUsuario;
    private final Email email;
    private final Name name;
    private final Image image;

    public PersonsGot(IdUsuario idUsuario, Email email, Name name, Image image) {
        super("persons.got");
        this.idUsuario = idUsuario;
        this.email = email;
        this.name = name;
        this.image = image;
    }

    public IdUsuario IdUsuario() {
        return idUsuario;
    }

    public Email Email() {
        return email;
    }

    public Name Name() {
        return name;
    }

    public Image Image() {
        return image;
    }
}

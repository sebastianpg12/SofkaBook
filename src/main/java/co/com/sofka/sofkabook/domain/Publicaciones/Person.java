package co.com.sofka.sofkabook.domain.Publicaciones;


import co.com.sofka.domain.generic.Entity;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Email;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdUsuario;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Image;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Person")
public class Person extends Entity<IdUsuario> {

    protected Email email;
    protected Name name;
    protected Image image;

    public Person(IdUsuario entityId, Email email, Name name, Image image) {
        super(entityId);
        this.email = email;
        this.name = name;
        this.image = image;
    }

    public Person(IdUsuario entityId) {
        super(entityId);
    }


    public Email getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }
}

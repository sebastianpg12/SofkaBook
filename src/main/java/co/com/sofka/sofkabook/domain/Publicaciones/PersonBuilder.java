package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.sofkabook.domain.Publicaciones.values.Email;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Image;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;

public final class PersonBuilder {
    protected Email email;
    protected Name name;
    protected Image image;

    private PersonBuilder() {
    }

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withEmail(Email email) {
        this.email = email;
        return this;
    }

    public PersonBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withImage(Image image) {
        this.image = image;
        return this;
    }

    public Person build() {
        return new Person(null, email, name, image);
    }
}

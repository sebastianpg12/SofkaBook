package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.sofkabook.domain.Publicaciones.values.Email;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Fecha;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;

public final class PersonBuilder {
    protected String idPro;
    protected Email email;
    protected Name name;
    protected Fecha fecha;

    private PersonBuilder() {
    }

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withIdPro(String idPro) {
        this.idPro = idPro;
        return this;
    }

    public PersonBuilder withEmail(Email email) {
        this.email = email;
        return this;
    }

    public PersonBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withFecha(Fecha fecha) {
        this.fecha = fecha;
        return this;
    }

    public Person build() {
        Person person = new Person(null, email, name, fecha);
        person.setIdPro(idPro);
        return person;
    }
}

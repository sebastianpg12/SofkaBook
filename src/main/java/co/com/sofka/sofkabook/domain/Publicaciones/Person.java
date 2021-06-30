package co.com.sofka.sofkabook.domain.Publicaciones;


import co.com.sofka.domain.generic.Entity;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person extends Entity<IdUsuario> {

    @Id
    protected String idPro;

    protected Email email;
    protected Name name;
    protected Fecha fecha;

    public Person(IdUsuario entityId, Email email, Name name, Fecha fecha) {
        super(entityId);
        this.idPro = entityId.value();
        this.email = email;
        this.name = name;
        this.fecha = fecha;
    }

    public void setIdPro(String idPro) {
        this.idPro = idPro;
    }

    public String getIdPro() {
        return idPro;
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

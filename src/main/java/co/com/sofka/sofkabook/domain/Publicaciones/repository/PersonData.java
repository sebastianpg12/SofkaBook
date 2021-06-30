package co.com.sofka.sofkabook.domain.Publicaciones.repository;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class PersonData {
    @Id
    protected String idperson;

    protected String email;
    protected String name;
    protected String fecha;

    public PersonData(String id, String email, String name, String fecha) {
        this.idperson = id;
        this.email = email;
        this.name = name;
        this.fecha = fecha;
    }

    public String getId() {
        return idperson;
    }

    public void setId(String idPro) {
        this.idperson = idPro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

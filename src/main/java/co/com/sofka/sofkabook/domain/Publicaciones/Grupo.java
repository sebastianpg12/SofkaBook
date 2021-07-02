package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.domain.generic.AggregateRoot;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Fecha;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdGrupo;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Titulo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "groups")
public class Grupo extends Entity<IdGrupo> {

    @Id
    protected String idPro;

    protected Titulo titulo;
    protected Fecha fecha;
    protected Name name;

    public Grupo(IdGrupo entityId, Titulo titulo, Fecha fecha, Name name) {
        super(entityId);
        this.idPro = entityId.value();
        this.titulo = titulo;
        this.fecha = fecha;
        this.name = name;
    }

    public void setIdPro(String idPro) {
        this.idPro = idPro;
    }

    public String getIdPro() {
        return idPro;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Name getName() {
        return name;
    }
}

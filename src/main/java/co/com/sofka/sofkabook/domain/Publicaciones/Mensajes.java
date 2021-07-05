package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menssages")
public class Mensajes extends Entity<IdMensajes> {

    @Id
    protected String idPro;

    protected Titulo titulo;
    protected Fecha fecha;
    protected Name name;
    protected IdGrupo idGrupo;

    public Mensajes(IdMensajes entityId, Titulo titulo, Fecha fecha, Name name, IdGrupo idGrupo) {
        super(entityId);
        this.idPro = entityId.value();
        this.titulo = titulo;
        this.fecha = fecha;
        this.name = name;
        this.idGrupo = idGrupo;
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

    public IdGrupo getIdGrupo() {
        return idGrupo;
    }
}

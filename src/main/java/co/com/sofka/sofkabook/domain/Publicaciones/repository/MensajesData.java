package co.com.sofka.sofkabook.domain.Publicaciones.repository;

import co.com.sofka.sofkabook.domain.Publicaciones.values.Fecha;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Titulo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menssages")
public class MensajesData {

    @Id
    protected String id;

    protected String titulo;
    protected String fecha;
    protected String name;
    protected String idGrupo;

    public MensajesData(String id, String titulo, String fecha, String name,  String idGrupo) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.name = name;
        this.idGrupo = idGrupo;
    }

    public String getId() {
        return id;
    }

    public void setId(String idPro) {
        this.id = idPro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }
}

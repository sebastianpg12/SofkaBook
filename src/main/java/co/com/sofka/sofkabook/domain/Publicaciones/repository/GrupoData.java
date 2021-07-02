package co.com.sofka.sofkabook.domain.Publicaciones.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "groups")
public class GrupoData {

    @Id
    protected String id;

    protected String titulo;
    protected String fecha;
    protected String name;

    public GrupoData(String id, String titulo, String fecha, String name) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.name = name;
    }

    public GrupoData() {
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
}

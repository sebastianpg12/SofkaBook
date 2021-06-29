package co.com.sofka.sofkabook.domain.Publicaciones.repository;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "post")
public class PostData {

    @Id
    protected String id;

    protected String idUsuario;
    protected String categoria;
    protected String fecha;
    protected String descripcion;
    protected String titulo;
    protected String name;


    public PostData(String id, String idUsuario, String categoria, String descripcion,
                    String titulo, String fecha, String name) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.categoria = categoria;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.name = name;


    }
    public PostData() {
    }


    public String getId() {
        return id;
    }

    public void setId(String idPro) {
        this.id = idPro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

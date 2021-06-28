package co.com.sofka.sofkabook.domain.Publicaciones;


import co.com.sofka.domain.generic.AggregateRoot;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "post")
public class Post extends AggregateRoot<PostId> {

    @Id
    protected String idPro;

    protected IdUsuario idUsuario;
    protected IdTitulo idTitulo;
    protected Fecha fecha;
    protected Descripcion descripcion;
    protected Titulo titulo;



    public Post(PostId entityId, IdUsuario idUsuario, IdTitulo idTitulo,
                Descripcion descripcion,Titulo titulo, Fecha fecha ){
        super(entityId);
        this.idUsuario = idUsuario;
        this.idPro = entityId.value();
        this.idTitulo = idTitulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.titulo = titulo;

    }

    public void setIdPro(String idPro) {
        this.idPro = idPro;
    }

    public String getIdPro() {
        return idPro;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public IdTitulo getIdTitulo() {
        return idTitulo;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Titulo getTitulo() { return titulo; }


}

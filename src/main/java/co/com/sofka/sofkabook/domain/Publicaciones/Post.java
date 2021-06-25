package co.com.sofka.sofkabook.domain.Publicaciones;


import co.com.sofka.domain.generic.AggregateRoot;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Document(collation = "Post")
public class Post extends AggregateRoot<PostId> {

    protected IdUsuario idUsuario;
    protected IdTitulo idTitulo;
    protected Fecha fecha;
    protected Descripcion descripcion;
    protected Titulo titulo;
    protected Comentario comentario;


    public Post(PostId entityId, IdUsuario idUsuario, IdTitulo idTitulo,
                Descripcion descripcion,Titulo titulo, Comentario comentario, Fecha fecha ){
        super(entityId);
        this.idUsuario = idUsuario;
        this.idTitulo = idTitulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.comentario = comentario;
    }

    public Post(PostId entityId, Comentario comentario) {
        super(entityId);
        this.idUsuario = idUsuario;
        this.idTitulo = idTitulo;
        this.comentario = comentario;
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

    public Comentario getComentario() {
        return comentario;
    }
}

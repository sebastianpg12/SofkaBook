package co.com.sofka.sofkabook.domain.Publicaciones.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public class PostCreated extends DomainEvent {
    private final PostId postId;
    private final IdUsuario idUsuario;
    private final IdTitulo idTitulo;
    private final Fecha fecha;
    private final Descripcion descripcion;
    private final Titulo titulo;


    public PostCreated(PostId postId, IdUsuario idUsuario, IdTitulo idTitulo, Fecha fecha, Descripcion descripcion, Titulo titulo) {
        super("Posts.post.created");
        this.postId = postId;
        this.idUsuario = idUsuario;
        this.idTitulo = idTitulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    public PostId PostId() {
        return postId;
    }

    public IdUsuario IdUsuario() {
        return idUsuario;
    }

    public IdTitulo IdTitulo() {
        return idTitulo;
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Descripcion Descripcion() {
        return descripcion;
    }

    public Titulo Titulo() {
        return titulo;
    }
}

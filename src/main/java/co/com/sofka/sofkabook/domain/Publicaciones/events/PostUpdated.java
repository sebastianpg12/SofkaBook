package co.com.sofka.sofkabook.domain.Publicaciones.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public class PostUpdated extends DomainEvent {
    private final PostId postId;
    private final IdUsuario idUsuario;
    private final Categoria categoria;
    private final Fecha fecha;
    private final Descripcion descripcion;
    private final Titulo titulo;



    public PostUpdated(PostId postId, IdUsuario idUsuario, Categoria categoria, Fecha fecha, Descripcion descripcion,
                       Titulo titulo) {
        super("Posts.post.created");
        this.postId = postId;
        this.idUsuario = idUsuario;
        this.categoria = categoria;
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

    public Categoria IdTitulo() {
        return categoria;
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

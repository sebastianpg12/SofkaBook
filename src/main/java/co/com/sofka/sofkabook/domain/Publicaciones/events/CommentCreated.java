package co.com.sofka.sofkabook.domain.Publicaciones.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public class CommentCreated extends DomainEvent {
    private final Comentario comentario;
    private final Fecha fecha;
    private final PostId postId;
    private final IdUsuario idUsuario;
    private final Name name;

    public CommentCreated(IdComentario idComentario, Comentario comentario,
                          Fecha fecha, PostId postId,
                          IdUsuario idUsuario, Name name) {
        super("comentario.created");
        this.comentario=comentario;
        this.fecha=fecha;
        this.postId=postId;
        this.idUsuario=idUsuario;
        this.name=name;
    }

    public Comentario Comentario() {
        return comentario;
    }

    public Fecha Fecha() {
        return fecha;
    }

    public PostId PostId() {
        return postId;
    }

    public IdUsuario IdUsuario() {
        return idUsuario;
    }

    public Name Name() {
        return name;
    }
}


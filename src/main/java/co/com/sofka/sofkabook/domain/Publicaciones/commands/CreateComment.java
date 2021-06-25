package co.com.sofka.sofkabook.domain.Publicaciones.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public class CreateComment implements Command {
    private final IdComentario idComentario;
    private final Comentario comentario;
    private final Fecha fecha;
    private final PostId postId;
    private final IdUsuario idUsuario;
    private final Name name;


    public CreateComment(IdComentario idComentario, Comentario comentario,
                         Fecha fecha, PostId postId,
                         IdUsuario idUsuario, Name name) {
        this.idComentario = idComentario;
        this.comentario=comentario;
        this.fecha=fecha;
        this.postId=postId;
        this.idUsuario=idUsuario;
        this.name=name;
    }

    public IdComentario IdComentario() { return idComentario; }

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


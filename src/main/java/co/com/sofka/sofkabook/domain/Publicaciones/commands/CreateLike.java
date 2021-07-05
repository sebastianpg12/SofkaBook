package co.com.sofka.sofkabook.domain.Publicaciones.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdLike;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdUsuario;
import co.com.sofka.sofkabook.domain.Publicaciones.values.PostId;

public class CreateLike implements Command {

    private final IdLike idLike;
    private final IdUsuario idUsuario;
    private final PostId postId;

    public CreateLike(IdLike idLike, IdUsuario idUsuario, PostId postId) {
        this.idLike = idLike;
        this.idUsuario = idUsuario;
        this.postId = postId;
    }

    public IdLike IdLike() {
        return idLike;
    }

    public IdUsuario IdUsuario() {
        return idUsuario;
    }

    public PostId PostId() {
        return postId;
    }
}



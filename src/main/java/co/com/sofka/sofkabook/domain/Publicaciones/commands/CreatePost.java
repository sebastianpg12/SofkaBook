package co.com.sofka.sofkabook.domain.Publicaciones.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public class CreatePost implements Command {
    private final PostId postId;
    private final IdUsuario idUsuario;
    private final IdTitulo idTitulo;
    private final Descripcion descripcion;
    private final Titulo titulo;
    private final Fecha fecha;

    public CreatePost(PostId postId, IdUsuario idUsuario, IdTitulo idTitulo,
                      Descripcion descripcion, Titulo titulo,  Fecha fecha) {
        this.postId = postId;
        this.idUsuario = idUsuario;
        this.idTitulo = idTitulo;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.fecha = fecha;
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

    public Descripcion Descripcion() {
        return descripcion;
    }

    public Titulo Titulo() {
        return titulo;
    }

    public Fecha Fecha() {
        return fecha;
    }
}

package co.com.sofka.sofkabook.domain.Publicaciones.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public class UpdatePost implements Command {
    private final PostId postId;
    private final IdUsuario idUsuario;
    private final Categoria categoria;
    private final Descripcion descripcion;
    private final Titulo titulo;
    private final Fecha fecha;
    private final Name name;


    public UpdatePost(PostId postId, IdUsuario idUsuario, Categoria categoria,
                      Descripcion descripcion, Titulo titulo,  Fecha fecha, Name name) {
        this.postId = postId;
        this.idUsuario = idUsuario;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.fecha = fecha;
        this.name = name;

    }

    public PostId PostId() {
        return postId;
    }

    public IdUsuario IdUsuario() {
        return idUsuario;
    }

    public Categoria Categoria() {
        return categoria;
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

    public Name Name() {
        return name;
    }


}

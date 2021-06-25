package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public final class PostBuilder {
    protected IdUsuario idUsuario;
    protected IdTitulo idTitulo;
    protected Fecha fecha;
    protected Descripcion descripcion;
    protected Titulo titulo;
    protected Comentario comentario;

    private PostBuilder() {
    }

    public static PostBuilder aPost() {
        return new PostBuilder();
    }

    public PostBuilder withIdUsuario(IdUsuario idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public PostBuilder withIdTitulo(IdTitulo idTitulo) {
        this.idTitulo = idTitulo;
        return this;
    }

    public PostBuilder withFecha(Fecha fecha) {
        this.fecha = fecha;
        return this;
    }

    public PostBuilder withDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public PostBuilder withTitulo(Titulo titulo) {
        this.titulo = titulo;
        return this;
    }

    public PostBuilder withComentario(Comentario comentario) {
        this.comentario = comentario;
        return this;
    }

    public Post build() {
        return new Post(null, idUsuario, idTitulo, descripcion, titulo, comentario, fecha);
    }
}

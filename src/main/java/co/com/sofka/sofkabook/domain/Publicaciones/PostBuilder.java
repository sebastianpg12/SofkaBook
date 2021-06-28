package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public final class PostBuilder {
    protected String idPro;
    protected IdUsuario idUsuario;
    protected IdTitulo idTitulo;
    protected Fecha fecha;
    protected Descripcion descripcion;
    protected Titulo titulo;
    protected Name name;

    private PostBuilder() {
    }

    public static PostBuilder aPost() {
        return new PostBuilder();
    }

    public PostBuilder withIdPro(String idPro) {
        this.idPro = idPro;
        return this;
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

    public PostBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public Post build() {
        Post post = new Post(null, idUsuario, idTitulo, descripcion, titulo, fecha, name);
        post.setIdPro(idPro);
        return post;
    }
}

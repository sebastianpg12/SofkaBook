package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.sofkabook.domain.Publicaciones.values.*;

public final class ComentariosBuilder {
    protected String idProComment;
    protected Comentario comentario;
    protected Fecha fecha;
    protected PostId postId;
    protected IdUsuario idUsuario;
    protected Name name;

    private ComentariosBuilder() {
    }

    public static ComentariosBuilder aComentarios() {
        return new ComentariosBuilder();
    }

    public ComentariosBuilder withIdProComment(String idProComment) {
        this.idProComment = idProComment;
        return this;
    }

    public ComentariosBuilder withComentario(Comentario comentario) {
        this.comentario = comentario;
        return this;
    }

    public ComentariosBuilder withFecha(Fecha fecha) {
        this.fecha = fecha;
        return this;
    }

    public ComentariosBuilder withPostId(PostId postId) {
        this.postId = postId;
        return this;
    }

    public ComentariosBuilder withIdUsuario(IdUsuario idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ComentariosBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public Comentarios build() {
        Comentarios comentarios = new Comentarios(null, comentario, fecha, postId, idUsuario, name);
        comentarios.setIdProComment(idProComment);
        return comentarios;
    }
}

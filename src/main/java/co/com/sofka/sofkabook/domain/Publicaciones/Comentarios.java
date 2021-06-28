package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "comments")
public class Comentarios extends Entity<IdComentario> {

    @Id
    protected String idProComment;

    protected Comentario comentario;
    protected Fecha fecha;
    protected PostId postId;
    protected IdUsuario idUsuario;
    protected Name name;


    public Comentarios(IdComentario entityId, Comentario comentario,
                       Fecha fecha, PostId postId,
                       IdUsuario idUsuario, Name name) {
        super(entityId);
        this.comentario=comentario;
        this.idProComment = entityId.value();
        this.fecha=fecha;
        this.postId=postId;
        this.idUsuario=idUsuario;
        this.name=name;
    }


    public void setIdProComment(String idProComment) {
        this.idProComment = idProComment;
    }

    public String getIdProComment() {
        return idProComment;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public PostId getPostId() {
        return postId;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Name getName() {
        return name;
    }
}

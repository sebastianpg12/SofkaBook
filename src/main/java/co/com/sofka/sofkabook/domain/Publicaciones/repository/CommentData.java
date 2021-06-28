package co.com.sofka.sofkabook.domain.Publicaciones.repository;

import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "comments")
public class CommentData {


    @Id
    protected String id;

    protected String comentario;
    protected String fecha;
    protected String postId;
    protected String idUsuario;
    protected String name;

    public CommentData(String id, String comentario,
                       String fecha, String postId, String idUsuario, String name) {
        this.id = id;
        this.comentario = comentario;
        this.fecha = fecha;
        this.postId = postId;
        this.idUsuario = idUsuario;
        this.name = name;
    }

    public CommentData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

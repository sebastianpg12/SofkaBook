package co.com.sofka.sofkabook.domain.Publicaciones.repository;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "likes")
public class LikeData {

    @Id
    protected String id;

    protected String idUsuario;
    protected String postId;


    public LikeData(String id, String idUsuario, String postId) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.postId = postId;
    }

    public LikeData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String idPro) {
        this.id = idPro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}


package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdLike;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdUsuario;
import co.com.sofka.sofkabook.domain.Publicaciones.values.PostId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "likes")
public class Like extends Entity<IdLike> {

    @Id
    protected String idPro;

    protected IdUsuario idUsuario;
    protected PostId postId;

    public Like(IdLike entityId, IdUsuario idUsuario, PostId postId) {
        super(entityId);
        this.idPro = entityId.value();
        this.idUsuario = idUsuario;
        this.postId = postId;
    }

    public void setIdPro(String idPro) {
        this.idPro = idPro;
    }

    public String getIdPro() {
        return idPro;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public PostId getPostId() {
        return postId;
    }
}

package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.sofkabook.domain.Publicaciones.values.IdUsuario;
import co.com.sofka.sofkabook.domain.Publicaciones.values.PostId;

public final class LikeBuilder {
    protected String idPro;
    protected IdUsuario idUsuario;
    protected PostId postId;

    private LikeBuilder() {
    }

    public static LikeBuilder aLike() {
        return new LikeBuilder();
    }

    public LikeBuilder withIdPro(String idPro) {
        this.idPro = idPro;
        return this;
    }

    public LikeBuilder withIdUsuario(IdUsuario idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public LikeBuilder withPostId(PostId postId) {
        this.postId = postId;
        return this;
    }

    public Like build() {
        Like like = new Like(null, idUsuario, postId);
        like.setIdPro(idPro);
        return like;
    }
}

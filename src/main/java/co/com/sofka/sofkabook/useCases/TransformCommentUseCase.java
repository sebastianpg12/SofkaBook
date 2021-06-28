package co.com.sofka.sofkabook.useCases;

import co.com.sofka.sofkabook.domain.Publicaciones.Comentarios;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.CommentData;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.ICommentDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformCommentUseCase {

    @Autowired
    private ICommentDataRepository data;

    public CommentData transform(Comentarios comentarios) {
        CommentData commentData = new CommentData(comentarios.getIdProComment(),comentarios.getComentario().value(),
                comentarios.getFecha().value(), comentarios.getPostId().value(), comentarios.getIdUsuario().value(),
                comentarios.getName().value());
        return  commentData;
    }
    public Iterable<CommentData> listComment(String postId) {
        return data.findByPostId(postId);
    }

    public String delete(String id) {

        try {
            data.deleteById(id);
            return "Se realizo el borrado con exito";
        } catch (Exception e) {
            return "No se pudo realizar el borrado con exito";
        }
    }
}

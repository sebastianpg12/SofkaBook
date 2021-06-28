package co.com.sofka.sofkabook.domain.Publicaciones.repository;
import co.com.sofka.sofkabook.domain.Publicaciones.Comentarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICommentDataRepository extends CrudRepository<CommentData, String>{

    Iterable<CommentData> findByPostId(String postId);
}

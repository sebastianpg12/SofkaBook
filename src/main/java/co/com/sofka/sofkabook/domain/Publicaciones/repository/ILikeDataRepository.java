package co.com.sofka.sofkabook.domain.Publicaciones.repository;


import org.springframework.data.repository.CrudRepository;

public interface ILikeDataRepository extends CrudRepository<LikeData, String>{
    Iterable<LikeData> findByPostId(String postId);
}

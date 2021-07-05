package co.com.sofka.sofkabook.domain.Publicaciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostDataRepository extends CrudRepository<PostData, String> {
    Iterable<PostData> findByCategoria(String categoria);
    Iterable<PostData> findByIdUsuario(String idUsuario);
}
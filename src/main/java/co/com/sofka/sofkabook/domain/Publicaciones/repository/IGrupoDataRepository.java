package co.com.sofka.sofkabook.domain.Publicaciones.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrupoDataRepository extends CrudRepository<GrupoData, String> {

}

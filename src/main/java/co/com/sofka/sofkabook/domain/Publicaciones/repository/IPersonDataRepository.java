package co.com.sofka.sofkabook.domain.Publicaciones.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonDataRepository extends CrudRepository<PersonData, String> {

}

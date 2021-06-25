package co.com.sofka.sofkabook.domain.Publicaciones.repository;

import co.com.sofka.sofkabook.domain.Publicaciones.Person;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends CrudRepository<Person, IdUsuario> {

}
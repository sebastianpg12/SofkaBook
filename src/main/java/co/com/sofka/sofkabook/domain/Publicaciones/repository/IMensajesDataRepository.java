package co.com.sofka.sofkabook.domain.Publicaciones.repository;

import org.springframework.data.repository.CrudRepository;

public interface IMensajesDataRepository extends CrudRepository<MensajesData, String>{
    Iterable<MensajesData> findByIdGrupo(String idGrupo);
}

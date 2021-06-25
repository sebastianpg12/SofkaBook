package co.com.sofka.sofkabook.domain.Publicaciones.repository;

import co.com.sofka.sofkabook.domain.Publicaciones.Comentarios;
import co.com.sofka.sofkabook.domain.Publicaciones.Person;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdComentario;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdUsuario;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepository  extends CrudRepository<Comentarios, IdComentario> {

}

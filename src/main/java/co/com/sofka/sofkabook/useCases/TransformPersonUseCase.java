package co.com.sofka.sofkabook.useCases;

import co.com.sofka.sofkabook.domain.Publicaciones.Person;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPersonDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PersonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformPersonUseCase {

    @Autowired
    private IPersonDataRepository data;

    public PersonData transform(Person person) {
        PersonData personData = new PersonData(person.getIdPro(), person.getEmail().value(),
                person.getName().value(), person.getFecha().value());
        return personData;
    }

    public Iterable<PersonData> listar(){
        return data.findAll();
    }
}

package co.com.sofka.sofkabook.useCases;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Person;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePerson;

import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPersonDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PersonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonUseCase extends UseCase<RequestCommand<CreatePerson>, CreatePersonUseCase.Response> {

    @Autowired
    private IPersonDataRepository data;

    @Override
    public void executeUseCase(RequestCommand<CreatePerson> createPersonRequestCommand) {
        var command = createPersonRequestCommand.getCommand();
        var person = new Person(command.getIdUsuario(),command.getEmail(), command.getName(), command.getFecha());
        data.save(transform(person));
        emit().onResponse(new Response(person));

    }

    public PersonData transform(Person person) {
        PersonData personData = new PersonData(person.getIdPro(), person.getEmail().value(),
                person.getName().value(), person.getFecha().value());
        return personData;
    }

    public static class Response implements UseCase.ResponseValues{

        private Person response;

        public Response(Person person) {
            this.response=person;
        }

        public Person getResponse() {
            return response;
        }

        public void setResponse(Person response) {
            this.response = response;
        }
    }
}

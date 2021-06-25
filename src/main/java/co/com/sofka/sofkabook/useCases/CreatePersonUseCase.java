package co.com.sofka.sofkabook.useCases;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Person;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePerson;

import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonUseCase extends UseCase<RequestCommand<CreatePerson>, CreatePersonUseCase.Response> {

    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    public void executeUseCase(RequestCommand<CreatePerson> createPersonRequestCommand) {
        var command = createPersonRequestCommand.getCommand();
        var person = new Person(command.IdUsuario(),command.Email(),command.Name(),command.Image());
        iPersonRepository.save(person);
        emit().onResponse(new Response(person));

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

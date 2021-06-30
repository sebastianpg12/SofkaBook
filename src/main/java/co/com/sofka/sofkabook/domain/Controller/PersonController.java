package co.com.sofka.sofkabook.domain.Controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePerson;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PersonData;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import co.com.sofka.sofkabook.useCases.CreatePersonUseCase;
import co.com.sofka.sofkabook.useCases.TransformPersonUseCase;
import co.com.sofka.sofkabook.useCases.UpdatePostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class PersonController {

    @Autowired
    private CreatePersonUseCase createPersonUseCase;

    @Autowired
    private TransformPersonUseCase transformPersonUseCase;



    @PostMapping(value = "apiUser/{IdUsuario}/{Email}/{Name}/{Fecha}")
    public String savePerson(@PathVariable("IdUsuario")String idUsuario,
                             @PathVariable("Email")String email,
                             @PathVariable("Name")String name,
                             @PathVariable("Fecha")String fecha){
        var command = new CreatePerson(IdUsuario.of(idUsuario), new Email(email), new Name(name), new Fecha(fecha));

        CreatePersonUseCase.Response personCreated = executeUseCase(command);

        String string = "{"
                + "\"IdUsuario\":" + "\""+personCreated.getResponse().identity()+"\""+ ","
                + "\"Email\":" + "\""+personCreated.getResponse().getEmail()+"\""+ ","
                + "\"Name\":" + "\""+personCreated.getResponse().getName()+"\""+ ","
                + "\"Fecha\":" + "\""+personCreated.getResponse().getFecha()
                +"}";
        return string;
    }

    private CreatePersonUseCase.Response executeUseCase(CreatePerson command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createPersonUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var PersonCreated = events;
        return PersonCreated;
    }

    @GetMapping(value = "api/persons/findPersons")
    public Iterable<PersonData> listar(){
        return (transformPersonUseCase.listar());
    }

}

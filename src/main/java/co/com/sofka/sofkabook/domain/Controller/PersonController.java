package co.com.sofka.sofkabook.domain.Controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePerson;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import co.com.sofka.sofkabook.useCases.CreatePersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PersonController {

    @Autowired
    private CreatePersonUseCase createPersonUseCase;



    @PostMapping(value = "apiUser/{IdUsuario}/{Email}/{Name}/{Image}")
    public String savePerson(@PathVariable("IdUsuario")String idUsuario,
                             @PathVariable("Email")String email,
                             @PathVariable("Name")String name,
                             @PathVariable("Image")String image){
        var command = new CreatePerson(IdUsuario.of(idUsuario), new Email(email), new Name(name), new Image(image));

        CreatePersonUseCase.Response personCreated = executeUseCase(command);

        return (personCreated.getResponse().getEmail().value()+
                " "+personCreated.getResponse().getEmail().value()+
                " "+personCreated.getResponse().getName().value()+
                " "+personCreated.getResponse().getImage().value());
    }

    private CreatePersonUseCase.Response executeUseCase(CreatePerson command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createPersonUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var PersonCreated = events;
        return PersonCreated;
    }


}

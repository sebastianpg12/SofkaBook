package co.com.sofka.sofkabook.domain.Controller;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateGrupo;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateMensaje;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.GrupoData;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.MensajesData;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import co.com.sofka.sofkabook.useCases.CreateGrupoUseCase;
import co.com.sofka.sofkabook.useCases.CreateMensajeUseCase;
import co.com.sofka.sofkabook.useCases.TransformGrupoUseCase;
import co.com.sofka.sofkabook.useCases.TransformMensajesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class GrupoController {

    @Autowired
    private CreateGrupoUseCase createGrupoUseCase;

    @Autowired
    private TransformGrupoUseCase transformGrupoUseCase;

    @Autowired
    private CreateMensajeUseCase createMensajeUseCase;

    @Autowired
    private TransformMensajesUseCase transformMensajesUseCase;

    @PostMapping(value = "apiGrupo/{IdGrupo}/{Titulo}/{Fecha}/{Name}")
    public String saveGrupo(@PathVariable("IdGrupo")String idGrupo,
                            @PathVariable("Titulo")String titulo,
                            @PathVariable("Fecha")String fecha,
                            @PathVariable("Name")String name){
        var command = new CreateGrupo(IdGrupo.of(idGrupo), new Titulo(titulo), new Fecha(fecha),
                new Name(name));

        CreateGrupoUseCase.Response grupoCreated = executeUseCase(command);

        String string = "{"
                + "\"IdGrupo\":" + "\""+grupoCreated.getResponse().identity()+"\""+ ","
                + "\"Titulo\":" + "\""+grupoCreated.getResponse().getTitulo()+"\""+ ","
                + "\"Fecha\":" + "\""+grupoCreated.getResponse().getFecha()+"\""+ ","
                + "\"Name\":" + "\""+grupoCreated.getResponse().getName()
                +"}";
        return string;
    }

    @PostMapping(value = "apiMensajes/{IdMensajes}/{Titulo}/{Fecha}/{Name}/{IdGrupo}")
    public String saveMensaje(@PathVariable("IdMensajes")String idMensajes,
                              @PathVariable("Titulo") String titulo,
                              @PathVariable("Fecha") String fecha,
                              @PathVariable("Name") String name,
                              @PathVariable("IdGrupo") String idGrupo
                              ){
        var command = new CreateMensaje(IdMensajes.of(idMensajes),
                new Titulo(titulo), new Fecha(fecha), new Name(name), IdGrupo.of(idGrupo));

        CreateMensajeUseCase.Response mensajeCreated = executeUseCase(command);

        String string =
                "{"
                        + "\"IdMensajes\":" + "\""+mensajeCreated.getResponse().identity()+"\""+ ","
                        + "\"Titulo\":" + "\""+mensajeCreated.getResponse().getTitulo()+"\""+ ","
                        + "\"Fecha\":" + "\""+mensajeCreated.getResponse().getFecha()+"\""+ ","
                        + "\"Name\":" + "\""+mensajeCreated.getResponse().getName()+"\""+ ","
                        + "\"IdGrupo\":" + "\""+mensajeCreated.getResponse().getIdGrupo()
                        +"}";
        return string;
    }

    private CreateGrupoUseCase.Response executeUseCase(CreateGrupo command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createGrupoUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var GrupoCreated = events;
        return GrupoCreated;
    }

    private CreateMensajeUseCase.Response executeUseCase(CreateMensaje command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createMensajeUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var MensajeCreated = events;
        return MensajeCreated;
    }

    @GetMapping(value = "apiMensajes/findByIdGrupo/{idGrupo}")
    public Iterable<MensajesData> listarChat(@PathVariable("idGrupo") String idGrupo){
        return (transformMensajesUseCase.listarChat(idGrupo));
    }

    @GetMapping(value = "apiGrupo/buscarGrupos")
    public Iterable<GrupoData> listar(){
        return (transformGrupoUseCase.listar());
    }


    @DeleteMapping(value = "apiGrupo/deleteGrupo/{id}")
    public String deleteGrupo(@PathVariable("id") String id) {
        return (transformGrupoUseCase.delete(id));


    }


    @DeleteMapping(value = "apiMensajes/deleteMensaje/{id}")
    public String deleteMensaje(@PathVariable("id") String id) {
        return (transformMensajesUseCase.deleteMensaje(id));


    }
}

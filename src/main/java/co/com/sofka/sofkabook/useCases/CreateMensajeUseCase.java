package co.com.sofka.sofkabook.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Mensajes;
import co.com.sofka.sofkabook.domain.Publicaciones.Post;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateMensaje;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IMensajesDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.MensajesData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMensajeUseCase extends UseCase<RequestCommand<CreateMensaje>, CreateMensajeUseCase.Response> {

    @Autowired
    private IMensajesDataRepository data;


    @Override
    public void executeUseCase(RequestCommand<CreateMensaje> createMensajeRequestCommand) {
        var command = createMensajeRequestCommand.getCommand();
        var mensajes = new Mensajes(command.IdMensajes(),command.Titulo(),command.Fecha(),
                command.Name(), command.IdGrupo());
        data.save(transform(mensajes));
        emit().onResponse(new Response(mensajes));
    }


    public MensajesData transform(Mensajes mensajes){
        MensajesData mensajesData = new MensajesData(mensajes.getIdPro(), mensajes.getTitulo().value(),
                mensajes.getFecha().value(), mensajes.getName().value(), mensajes.getIdGrupo().value());
        return mensajesData;
    }

    public static class Response implements UseCase.ResponseValues{

        private Mensajes response;

        public Response(Mensajes mensajes) {
            this.response=mensajes;
        }

        public Mensajes getResponse() {
            return response;
        }

        public void setResponse(Mensajes response) {
            this.response = response;
        }
    }

}

package co.com.sofka.sofkabook.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Comentarios;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateComment;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCommentUseCase extends UseCase<RequestCommand<CreateComment>, CreateCommentUseCase.Response> {

    @Autowired
    private ICommentRepository iCommentRepository;

   @Override
    public void executeUseCase(RequestCommand<CreateComment> CreateCommentRequestCommand) {
        var command = CreateCommentRequestCommand.getCommand();
        var comentarios = new Comentarios(command.IdComentario(), command.Comentario(),command.Fecha(),
                command.PostId(),command.IdUsuario(),command.Name());
       iCommentRepository.save(comentarios);
        emit().onResponse(new CreateCommentUseCase.Response(comentarios));

    }
    public static class Response implements UseCase.ResponseValues{

        private Comentarios response;

        public Response(Comentarios comentarios) {
            this.response=comentarios;
        }

        public Comentarios getResponse() {
            return response;
        }

        public void setResponse(Comentarios response) {
            this.response = response;
        }
    }

}

package co.com.sofka.sofkabook.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Comentarios;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateComment;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.CommentData;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.ICommentDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCommentUseCase extends UseCase<RequestCommand<CreateComment>, CreateCommentUseCase.Response> {

    @Autowired
    private ICommentDataRepository data;

    @Override
    public void executeUseCase(RequestCommand<CreateComment> CreateCommentRequestCommand) {
        CreateComment command = CreateCommentRequestCommand.getCommand();
        Comentarios comentarios = new Comentarios(command.IdComentario(), command.Comentario(),command.Fecha(),
                command.PostId(),command.IdUsuario(),command.Name());
       data.save(transform(comentarios));
        emit().onResponse(new Response(comentarios));
    }

    public CommentData transform(Comentarios comentarios) {
        CommentData commentData = new CommentData(comentarios.getIdProComment(),comentarios.getComentario().value(),
                comentarios.getFecha().value(), comentarios.getPostId().value(), comentarios.getIdUsuario().value(),
                comentarios.getName().value());
        return  commentData;
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

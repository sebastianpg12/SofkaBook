package co.com.sofka.sofkabook.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.sofkabook.domain.Publicaciones.Post;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePost;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPostRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Comentario;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatePostUseCase extends UseCase<RequestCommand<CreatePost>, CreatePostUseCase.Response> {



    @Autowired
    private IPostRepository iPostRepository;

    @Override
    public void executeUseCase(RequestCommand<CreatePost> createPostRequestCommand) {
        var command = createPostRequestCommand.getCommand();
        var post = new Post(command.PostId(), command.IdUsuario(), command.IdTitulo(),
                command.Descripcion(), command.Titulo(), command.Comentario(), command.Fecha());
        iPostRepository.save(post);
        emit().onResponse(new Response(post));
    }

    public static class Response implements UseCase.ResponseValues{

        private Post response;

        public Response(Post post) {
            this.response=post;
        }

        public Post getResponse() {
            return response;
        }

        public void setResponse(Post response) {
            this.response = response;
        }
    }


}

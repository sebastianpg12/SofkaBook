package co.com.sofka.sofkabook.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Post;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePost;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPostDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePostUseCase extends UseCase<RequestCommand<CreatePost>, CreatePostUseCase.Response> {

    @Autowired
    private IPostDataRepository data;


    @Override
    public void executeUseCase(RequestCommand<CreatePost> createPostRequestCommand) {
        var command = createPostRequestCommand.getCommand();
        var post = new Post(command.PostId(), command.IdUsuario(), command.IdTitulo(),
                command.Descripcion(), command.Titulo(), command.Fecha(), command.Name());
        data.save(transform(post));
        emit().onResponse(new Response(post));
    }

    public PostData transform(Post post) {
        PostData postData = new PostData(post.getIdPro(), post.getIdUsuario().value(), post.getIdTitulo().value(),
                post.getDescripcion().value(),post.getTitulo().value(),post.getFecha().value(),post.getName().value());
        return postData ;
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

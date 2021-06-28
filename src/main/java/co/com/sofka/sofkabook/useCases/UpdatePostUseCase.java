package co.com.sofka.sofkabook.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Post;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePost;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.UpdatePost;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPostDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePostUseCase extends UseCase<RequestCommand<UpdatePost>, UseCase.ResponseValues> {

    @Autowired
    private IPostDataRepository data;


    @Override
    public void executeUseCase(RequestCommand<UpdatePost> updatePostRequestCommand) {
            var command = updatePostRequestCommand.getCommand();
            var post = new Post(command.PostId(), command.IdUsuario(), command.IdTitulo(),
                    command.Descripcion(), command.Titulo(), command.Fecha());
            data.save(transform(post));
            emit().onResponse(new Response(post));
        }


    public PostData transform(Post post) {
        PostData postData = new PostData(post.getIdPro(), post.getIdUsuario().value(), post.getIdTitulo().value(),
                post.getDescripcion().value(),post.getTitulo().value(),post.getFecha().value());
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

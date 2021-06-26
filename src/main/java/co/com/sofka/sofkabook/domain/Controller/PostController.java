package co.com.sofka.sofkabook.domain.Controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Comentarios;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateComment;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePost;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import co.com.sofka.sofkabook.useCases.CreateCommentUseCase;
import co.com.sofka.sofkabook.useCases.CreatePostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private CreatePostUseCase createPostUseCase;

    @Autowired
    private CreateCommentUseCase createCommentUseCase;

    @PostMapping(value = "api/{PostId}/{IdUsuario}/{IdTitulo}/{Descripcion}/{Titulo}/{Comentarios}/{Fecha}")
    public String save(@PathVariable("PostId")String postId,
                       @PathVariable("IdUsuario")String idUsuario,
                       @PathVariable("IdTitulo")String idTitulo,
                       @PathVariable("Descripcion")String descripcion,
                       @PathVariable("Titulo")String titulo,
                        @PathVariable("Comentarios")  String comentario,
                        @PathVariable("Fecha") String fecha)
    {
        var command = new CreatePost(PostId.of(postId),
                IdUsuario.of(idUsuario),
                IdTitulo.of(idTitulo),
                new Descripcion(descripcion),
                new Titulo(titulo),
                new Comentario(comentario),
                new Fecha(fecha));

        CreatePostUseCase.Response postCreated = executeUseCase(command);
        String string = "{"
                + "\"PostId\":" + "\""+postCreated.getResponse().identity()+"\""+ ","
                + "\"IdUsuario\":" + "\""+postCreated.getResponse().getIdUsuario()+"\""+ ","
                + "\"IdTitulo\":" + "\""+postCreated.getResponse().getIdTitulo()+"\""+ ","
                + "\"Descripcion\":" + "\""+postCreated.getResponse().getDescripcion()+"\""+ ","
                + "\"Titulo\":" + "\""+postCreated.getResponse().getTitulo()+"\""+ ","
                + "\"Comentarios\":" + "\""+postCreated.getResponse().getComentario()+"\""+ ","
                + "\"Fecha\":" + "\""+postCreated.getResponse().getFecha()
                +"}";

        return string;
    }

    @PostMapping(value = "apiComment/{IdComentario}/{Comentario}/{Fecha}/{PostId}/{IdUsuario}/{Name}")
    public String saveComment(@PathVariable("IdComentario")String idComentario,
                              @PathVariable("Comentario") String comentario,
                              @PathVariable("Fecha") String fecha,
                              @PathVariable("PostId") String postId,
                              @PathVariable("IdUsuario") String idUsuario,
                              @PathVariable("Name") String name)

    {
        var command = new CreateComment(IdComentario.of(idComentario),
                new Comentario(comentario), new Fecha(fecha), PostId.of(postId)
                        ,IdUsuario.of(idUsuario), new Name(name));


        CreateCommentUseCase.Response CommentCreated = executeUseCase(command);
        return (" "+CommentCreated.getResponse().getComentario().value()+
                " "+CommentCreated.getResponse().getFecha().value()+
                " "+CommentCreated.getResponse().getPostId().value()+
                " "+CommentCreated.getResponse().getIdUsuario().value()+
                " "+CommentCreated.getResponse().getName().value());
    }

    private CreatePostUseCase.Response executeUseCase(CreatePost command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createPostUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var PostCreated = events;
        return PostCreated;
    }

    private CreateCommentUseCase.Response executeUseCase(CreateComment command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createCommentUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var CommentCreated = events;
        return CommentCreated;
    }

}

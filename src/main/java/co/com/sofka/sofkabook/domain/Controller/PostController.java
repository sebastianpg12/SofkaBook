package co.com.sofka.sofkabook.domain.Controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Comentarios;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateComment;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePost;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.UpdatePost;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import co.com.sofka.sofkabook.useCases.CreateCommentUseCase;
import co.com.sofka.sofkabook.useCases.CreatePostUseCase;
import co.com.sofka.sofkabook.useCases.TransformPostUseCase;
import co.com.sofka.sofkabook.useCases.UpdatePostUseCase;
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

    @Autowired
    private TransformPostUseCase transformPostUseCase;

    @Autowired
    private UpdatePostUseCase updatePostUseCase;


    //actualizar
    @PutMapping(value = "api/actualizar/{PostId}/{IdUsuario}/{IdTitulo}/{Descripcion}/{Titulo}/{Comentarios}/{Fecha}")
    public String actualizar(@PathVariable("PostId")String postId,
                       @PathVariable("IdUsuario")String idUsuario,
                       @PathVariable("IdTitulo")String idTitulo,
                       @PathVariable("Descripcion")String descripcion,
                       @PathVariable("Titulo")String titulo,
                       @PathVariable("Comentarios")  String comentario,
                       @PathVariable("Fecha") String fecha)
    {
        var command = new UpdatePost(PostId.of(postId),
                IdUsuario.of(idUsuario),
                IdTitulo.of(idTitulo),
                new Descripcion(descripcion),
                new Titulo(titulo),
                new Comentario(comentario),
                new Fecha(fecha));

        UpdatePostUseCase.Response postUpdated = executeUseCase(command);
        String string = "{"
                + "\"PostId\":" + "\""+postUpdated.getResponse().identity()+"\""+ ","
                + "\"IdUsuario\":" + "\""+postUpdated.getResponse().getIdUsuario()+"\""+ ","
                + "\"IdTitulo\":" + "\""+postUpdated.getResponse().getIdTitulo()+"\""+ ","
                + "\"Descripcion\":" + "\""+postUpdated.getResponse().getDescripcion()+"\""+ ","
                + "\"Titulo\":" + "\""+postUpdated.getResponse().getTitulo()+"\""+ ","
                + "\"Comentarios\":" + "\""+postUpdated.getResponse().getComentario()+"\""+ ","
                + "\"Fecha\":" + "\""+postUpdated.getResponse().getFecha()
                +"}";

        return string;
    }
    private UpdatePostUseCase.Response executeUseCase(UpdatePost command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(updatePostUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var PostUpdated = events;
        return (UpdatePostUseCase.Response) PostUpdated;
    }

    //Save
    @PostMapping(value = "api/guardar/{PostId}/{IdUsuario}/{IdTitulo}/{Descripcion}/{Titulo}/{Comentarios}/{Fecha}")
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

    private CreatePostUseCase.Response executeUseCase(CreatePost command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createPostUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var PostCreated = events;
        return PostCreated;
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


    private CreateCommentUseCase.Response executeUseCase(CreateComment command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createCommentUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var CommentCreated = events;
        return CommentCreated;
    }




    @GetMapping(value = "api/findPosts")
    public Iterable<PostData> listar(){
        return (transformPostUseCase.listar());
    }

    @GetMapping(value = "api/findPerson/{id}")
    public PostData listarId(@PathVariable("id") String id){
        return (transformPostUseCase.listarId(id));
    }
    @DeleteMapping(value = "api/delete/{id}")
    public String delete(@PathVariable("id") String id){
        return (transformPostUseCase.delete(id));
    }

}

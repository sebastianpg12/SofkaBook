package co.com.sofka.sofkabook.domain.Controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateComment;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreatePost;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.UpdatePost;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.CommentData;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import co.com.sofka.sofkabook.useCases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private TransformCommentUseCase transformCommentUseCase;

    @Autowired
    private UpdatePostUseCase updatePostUseCase;



    //actualizar
    @PutMapping(value = "api/actualizar/{PostId}/{IdUsuario}/{Categoria}/{Descripcion}/{Titulo}/{Fecha}/{Name}")
    public String actualizar(@PathVariable("PostId")String postId,
                       @PathVariable("IdUsuario")String idUsuario,
                       @PathVariable("Categoria")String categoria,
                       @PathVariable("Descripcion")String descripcion,
                       @PathVariable("Titulo")String titulo,
                       @PathVariable("Fecha") String fecha,
                             @PathVariable("Name") String name)
    {
        UpdatePost command = new UpdatePost(PostId.of(postId),
                IdUsuario.of(idUsuario),
                new Categoria(categoria),
                new Descripcion(descripcion),
                new Titulo(titulo),
                new Fecha(fecha),
                 new Name(name));

        UpdatePostUseCase.Response postUpdated = executeUseCase(command);
        String string = "{"
                + "\"PostId\":" + "\""+postUpdated.getResponse().identity()+"\""+ ","
                + "\"IdUsuario\":" + "\""+postUpdated.getResponse().getIdUsuario()+"\""+ ","
                + "\"Categoria\":" + "\""+postUpdated.getResponse().getCategoria()+"\""+ ","
                + "\"Descripcion\":" + "\""+postUpdated.getResponse().getDescripcion()+"\""+ ","
                + "\"Titulo\":" + "\""+postUpdated.getResponse().getTitulo()+"\""+ ","
                + "\"Fecha\":" + "\""+postUpdated.getResponse().getFecha()+"\""+ ","
                + "\"Name\":" + "\""+postUpdated.getResponse().getName()
                +"}";

        return string;
    }
    private UpdatePostUseCase.Response executeUseCase(UpdatePost command) {
        UpdatePostUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(updatePostUseCase, new RequestCommand<>(command))
                .orElseThrow();
        UpdatePostUseCase.Response PostUpdated = events;
        return PostUpdated;
    }

    //Save
    @PostMapping(value = "api/guardar/{PostId}/{IdUsuario}/{Categoria}/{Descripcion}/{Titulo}/{Fecha}/{Name}")
    public String save(@PathVariable("PostId")String postId,
                             @PathVariable("IdUsuario")String idUsuario,
                             @PathVariable("Categoria")String categoria,
                             @PathVariable("Descripcion")String descripcion,
                             @PathVariable("Titulo")String titulo,
                             @PathVariable("Fecha") String fecha,
                             @PathVariable("Name") String name)
    {
        CreatePost command = new CreatePost(PostId.of(postId),
                IdUsuario.of(idUsuario),
                new Categoria(categoria),
                new Descripcion(descripcion),
                new Titulo(titulo),
                new Fecha(fecha),
                new Name(name));

        CreatePostUseCase.Response postCreated = executeUseCase(command);
        String string = "{"
                + "\"PostId\":" + "\""+postCreated.getResponse().identity()+"\""+ ","
                + "\"IdUsuario\":" + "\""+postCreated.getResponse().getIdUsuario()+"\""+ ","
                + "\"Categoria\":" + "\""+postCreated.getResponse().getCategoria()+"\""+ ","
                + "\"Descripcion\":" + "\""+postCreated.getResponse().getDescripcion()+"\""+ ","
                + "\"Titulo\":" + "\""+postCreated.getResponse().getTitulo()+"\""+ ","
                + "\"Fecha\":" + "\""+postCreated.getResponse().getFecha()+"\""+ ","
                + "\"Name\":" + "\""+postCreated.getResponse().getName()
                +"}";

        return string;
    }

    private CreatePostUseCase.Response executeUseCase(CreatePost command) {
        CreatePostUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(createPostUseCase, new RequestCommand<>(command))
                .orElseThrow();
        CreatePostUseCase.Response PostCreated = events;
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
        CreateComment command = new CreateComment(IdComentario.of(idComentario),
                new Comentario(comentario), new Fecha(fecha), PostId.of(postId)
                        ,IdUsuario.of(idUsuario), new Name(name));


        CreateCommentUseCase.Response CommentCreated = executeUseCase(command);
        String string = "{"
                + "\"IdComentario\":" + "\""+CommentCreated.getResponse().identity()+"\""+ ","
                + "\"Comentario\":" + "\""+CommentCreated.getResponse().getComentario()+"\""+ ","
                + "\"Fecha\":" + "\""+CommentCreated.getResponse().getFecha()+"\""+ ","
                + "\"PostId\":" + "\""+CommentCreated.getResponse().getPostId()+"\""+ ","
                + "\"IdUsuario\":" + "\""+CommentCreated.getResponse().getIdUsuario()+"\""+ ","
                + "\"Name\":" + "\""+CommentCreated.getResponse().getName()
                +"}";

        return string;
    }



    private CreateCommentUseCase.Response executeUseCase(CreateComment command) {
        CreateCommentUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(createCommentUseCase, new RequestCommand<>(command))
                .orElseThrow();
        CreateCommentUseCase.Response CommentCreated = events;
        return CommentCreated;
    }



    @DeleteMapping(value = "apiComment/delete/{id}")
    public String deleteComment(@PathVariable("id") String id){
        return (transformCommentUseCase.delete(id));
    }

    @GetMapping(value = "api/findComments/{postId}")
    public Iterable<CommentData> listarCommentsId(@PathVariable("postId") String postId){
        return (transformCommentUseCase.listComment(postId));
    }

   @GetMapping(value = "api/findByCategory/{categoria}")
    public Iterable<PostData> listarCategoria(@PathVariable("categoria") String categoria){
        return (transformPostUseCase.listarCategoria(categoria));
    }

    @GetMapping(value = "api/findPosts")
    public Iterable<PostData> listar(){
        return (transformPostUseCase.listar());
    }

    @GetMapping(value = "api/findPosts/{id}")
    public PostData listarId(@PathVariable("id") String id){
        return (transformPostUseCase.listarId(id));
    }

    @DeleteMapping(value = "api/delete/{id}")
    public String delete(@PathVariable("id") String id){
        return (transformPostUseCase.delete(id));
    }

}

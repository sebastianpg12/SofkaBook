package co.com.sofka.sofkabook.useCases;


import co.com.sofka.sofkabook.domain.Publicaciones.Comentarios;
import co.com.sofka.sofkabook.domain.Publicaciones.Post;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPostDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformPostUseCase {

    @Autowired
    private IPostDataRepository data;


    public PostData transform(Post post) {
        PostData postData = new PostData(post.getIdPro(), post.getIdUsuario().value(), post.getIdTitulo().value(),
                post.getDescripcion().value(),post.getTitulo().value(),post.getFecha().value());
        return postData ;
    }

    public Iterable<PostData> listar(){
        return data.findAll();
    }

    public PostData listarId(String id) {
        return data.findById(id).orElseThrow(RuntimeException::new);
    }

    public String delete(String id) {

        try {
            data.deleteById(id);
            return "Se realizo el borrado con exito";
        }catch(Exception e){
            return "No se pudo realizar el borrado con exito";
        }
    }


}

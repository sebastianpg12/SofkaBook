package co.com.sofka.sofkabook.useCases;

import co.com.sofka.sofkabook.domain.Publicaciones.Like;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.ILikeDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.LikeData;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.MensajesData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformLikeUseCase {

    @Autowired
    private ILikeDataRepository data;

    public LikeData transform (Like like){
        LikeData likeData = new LikeData(like.getIdPro(), like.getIdUsuario().value(),
                like.getPostId().value());
        return likeData;
    }

 public Iterable<LikeData> listarLike(String postId){return data.findByPostId(postId);}
}



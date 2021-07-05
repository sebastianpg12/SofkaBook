package co.com.sofka.sofkabook.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Like;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateLike;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.ILikeDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.LikeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateLikeUseCase extends UseCase<RequestCommand<CreateLike>, CreateLikeUseCase.Response> {

    @Autowired
    private ILikeDataRepository data;

    @Override
    public void executeUseCase(RequestCommand<CreateLike> createLikeRequestCommand) {
        CreateLike command = createLikeRequestCommand.getCommand();
        Like like = new Like(command.IdLike(), command.IdUsuario(), command.PostId());

        data.save(transform(like));
        emit().onResponse(new Response(like));

    }

    public LikeData transform(Like like) {
        LikeData likeData = new LikeData(like.getIdPro(), like.getIdUsuario().value(),
                like.getPostId().value());
        return likeData;

    }
    public static class Response implements UseCase.ResponseValues{

        private Like response;

        public Response(Like like) {
            this.response=like;
        }

        public Like getResponse() {
            return response;
        }

        public void setResponse(Like response) {
            this.response = response;
        }
    }
}
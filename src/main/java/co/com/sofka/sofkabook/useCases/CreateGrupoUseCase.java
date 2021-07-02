package co.com.sofka.sofkabook.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.sofkabook.domain.Publicaciones.Grupo;
import co.com.sofka.sofkabook.domain.Publicaciones.Post;
import co.com.sofka.sofkabook.domain.Publicaciones.commands.CreateGrupo;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.GrupoData;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IGrupoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateGrupoUseCase extends UseCase<RequestCommand<CreateGrupo>, CreateGrupoUseCase.Response> {

    @Autowired
    private IGrupoDataRepository data;

    @Override
    public void executeUseCase(RequestCommand<CreateGrupo> createGrupoRequestCommand) {
        var command = createGrupoRequestCommand.getCommand();
        var grupo = new Grupo(command.IdGrupo(),command.Titulo(),command.Fecha(),command.Name());
        data.save(transform(grupo));
        emit().onResponse(new Response(grupo));
    }

    public GrupoData transform(Grupo grupo) {
        GrupoData grupoData = new GrupoData(grupo.getIdPro(),grupo.getTitulo().value(),
                grupo.getFecha().value(),grupo.getName().value());
        return grupoData;
    }

    public static class Response implements UseCase.ResponseValues{

        private Grupo response;

        public Response(Grupo grupo) {
            this.response=grupo;
        }

        public Grupo getResponse() {
            return response;
        }

        public void setResponse(Grupo response) {
            this.response = response;
        }
    }
}

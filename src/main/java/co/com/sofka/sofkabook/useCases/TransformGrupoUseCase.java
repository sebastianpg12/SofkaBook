package co.com.sofka.sofkabook.useCases;

import co.com.sofka.sofkabook.domain.Publicaciones.Grupo;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.GrupoData;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IGrupoDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.MensajesData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformGrupoUseCase {

    @Autowired
    private IGrupoDataRepository data;

    public GrupoData transform(Grupo grupo) {
        GrupoData grupoData = new GrupoData(grupo.getIdPro(),grupo.getTitulo().value(),
                grupo.getFecha().value(),grupo.getName().value());
        return grupoData;
    }
    public Iterable<GrupoData> listar(){
        return data.findAll();
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

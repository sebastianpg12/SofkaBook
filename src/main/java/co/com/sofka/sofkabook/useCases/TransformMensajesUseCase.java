package co.com.sofka.sofkabook.useCases;

import co.com.sofka.sofkabook.domain.Publicaciones.Mensajes;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IMensajesDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.MensajesData;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformMensajesUseCase {

    @Autowired
    private IMensajesDataRepository data;

    public MensajesData transform(Mensajes mensajes){
        MensajesData mensajesData = new MensajesData(mensajes.getIdPro(), mensajes.getTitulo().value(),
                mensajes.getFecha().value(), mensajes.getName().value(), mensajes.getIdGrupo().value());
        return mensajesData;
    }

    public Iterable<MensajesData> listarChat(String idGrupo){
        return data.findByIdGrupo(idGrupo);
    }


    public String deleteMensaje(String id) {

        try {
            data.deleteById(id);
            return "Se realizo el borrado con exito";
        }catch(Exception e){
            return "No se pudo realizar el borrado con exito";
        }
    }
}

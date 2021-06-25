package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.Identity;

public class IdComentario extends Identity {
    private IdComentario(String id){
        super(id);
    }

    public static IdComentario of (String id){
        return new IdComentario(id);
    }
}
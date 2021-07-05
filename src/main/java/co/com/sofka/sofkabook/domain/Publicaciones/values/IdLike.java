package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.Identity;

public class IdLike extends Identity {
    private IdLike(String id){
        super(id);
    }

    public static IdLike of (String id){
        return new IdLike(id);
    }
}
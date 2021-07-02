package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.Identity;

public class IdMensajes extends Identity {
    private IdMensajes(String id){
        super(id);
    }

    public static IdMensajes of (String id){
        return new IdMensajes(id);
    }
}
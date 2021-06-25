package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.Identity;

public class IdTitulo extends Identity {
    private IdTitulo(String id){
        super(id);
    }

    public static IdTitulo of (String id){
        return new IdTitulo(id);
    }
}
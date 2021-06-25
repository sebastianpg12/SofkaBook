package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.Identity;

public class IdUsuario extends Identity {
    private IdUsuario(String id){
        super(id);
    }

    public static IdUsuario of (String id){
        return new IdUsuario(id);
    }
}

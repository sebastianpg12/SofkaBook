package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.Identity;

public class IdGrupo extends Identity {
    private IdGrupo(String id){
        super(id);
    }

    public static IdGrupo of (String id){
        return new IdGrupo(id);
    }
}
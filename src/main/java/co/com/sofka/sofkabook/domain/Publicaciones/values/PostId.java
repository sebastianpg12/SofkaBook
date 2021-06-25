package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.Identity;

public class PostId extends Identity {
    private PostId(String id){
        super(id);
    }

    public static PostId of (String id){
        return new PostId(id);
    }
}

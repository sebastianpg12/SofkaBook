package co.com.sofka.sofkabook.domain.Publicaciones.values;
import co.com.sofka.domain.generic.ValueObject;

import java.util.List;

public class Comentario implements ValueObject<String>{
    private final String value;

    public Comentario(String value) {
        this.value = value;
    }

    @Override
    public String value(){
        return value;
    }
}

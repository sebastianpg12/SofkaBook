package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.ValueObject;

public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value) {
       this.value = value;
    }

    @Override
    public String value(){
        return value;
    }
}

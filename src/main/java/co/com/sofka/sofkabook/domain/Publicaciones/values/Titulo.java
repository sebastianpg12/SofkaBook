package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.ValueObject;

public class Titulo implements ValueObject<String> {
    private final String value;

    public Titulo(String value) {
        this.value = value;
    }

    @Override
    public String value(){
        return value;
    }
}

package co.com.sofka.sofkabook.domain.Publicaciones.values;

import co.com.sofka.domain.generic.ValueObject;

public class Image implements ValueObject<String> {
    private final String value;

    public Image(String value) {
        this.value = value;
    }

    @Override
    public String value(){
        return value;
    }
}

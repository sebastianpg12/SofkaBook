package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.sofkabook.domain.Publicaciones.values.Fecha;
import co.com.sofka.sofkabook.domain.Publicaciones.values.IdGrupo;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Titulo;

public final class MensajesBuilder {
    protected String idPro;
    protected Titulo titulo;
    protected Fecha fecha;
    protected Name name;
    protected IdGrupo idGrupo;

    private MensajesBuilder() {
    }

    public static MensajesBuilder aMensajes() {
        return new MensajesBuilder();
    }

    public MensajesBuilder withIdPro(String idPro) {
        this.idPro = idPro;
        return this;
    }

    public MensajesBuilder withTitulo(Titulo titulo) {
        this.titulo = titulo;
        return this;
    }

    public MensajesBuilder withFecha(Fecha fecha) {
        this.fecha = fecha;
        return this;
    }

    public MensajesBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public MensajesBuilder withIdGrupo(IdGrupo idGrupo) {
        this.idGrupo = idGrupo;
        return this;
    }

    public Mensajes build() {
        Mensajes mensajes = new Mensajes(null, titulo, fecha, name, idGrupo);
        mensajes.setIdPro(idPro);
        return mensajes;
    }
}

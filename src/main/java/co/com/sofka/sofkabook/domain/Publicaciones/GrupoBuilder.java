package co.com.sofka.sofkabook.domain.Publicaciones;

import co.com.sofka.sofkabook.domain.Publicaciones.values.Fecha;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Name;
import co.com.sofka.sofkabook.domain.Publicaciones.values.Titulo;

public final class GrupoBuilder {
    protected String idPro;
    protected Titulo titulo;
    protected Fecha fecha;
    protected Name name;

    private GrupoBuilder() {
    }

    public static GrupoBuilder aGrupo() {
        return new GrupoBuilder();
    }

    public GrupoBuilder withIdPro(String idPro) {
        this.idPro = idPro;
        return this;
    }

    public GrupoBuilder withTitulo(Titulo titulo) {
        this.titulo = titulo;
        return this;
    }

    public GrupoBuilder withFecha(Fecha fecha) {
        this.fecha = fecha;
        return this;
    }

    public GrupoBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public Grupo build() {
        Grupo grupo = new Grupo(null, titulo, fecha, name);
        grupo.setIdPro(idPro);
        return grupo;
    }
}

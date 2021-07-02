package co.com.sofka.sofkabook.domain.Publicaciones;


import co.com.sofka.domain.generic.AggregateRoot;
import co.com.sofka.sofkabook.domain.Publicaciones.values.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "post")
public class Post extends AggregateRoot<PostId> {

    @Id
    protected String idPro;

    protected IdUsuario idUsuario;
    protected Categoria categoria;
    protected Fecha fecha;
    protected Descripcion descripcion;
    protected Titulo titulo;
    protected Name name;


    public Post(PostId entityId, IdUsuario idUsuario, Categoria categoria,
                Descripcion descripcion,Titulo titulo, Fecha fecha, Name name){
        super(entityId);
        this.idUsuario = idUsuario;
        this.idPro = entityId.value();
        this.categoria = categoria;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.name = name;

    }

    public void setIdPro(String idPro) {
        this.idPro = idPro;
    }

    public String getIdPro() {
        return idPro;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Titulo getTitulo() { return titulo; }

    public Name getName() {
        return name;
    }


}

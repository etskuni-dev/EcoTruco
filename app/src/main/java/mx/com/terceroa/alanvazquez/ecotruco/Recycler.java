package mx.com.terceroa.alanvazquez.ecotruco;

/**
 * Created by AlanVazquez on 11/04/17.
 */

public class Recycler {
    String descripcion;
    String titulo;
    String ubicacion;
    String urlImagen;

    public Recycler(){

    }

    public Recycler(String descripcion, String titulo, String ubicacion, String urlImagen) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.urlImagen = urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}

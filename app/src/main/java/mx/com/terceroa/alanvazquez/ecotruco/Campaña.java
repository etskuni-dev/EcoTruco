package mx.com.terceroa.alanvazquez.ecotruco;

/**
 * Created by AlanVazquez on 11/04/17.
 */

public class Campaña {

    String titulo;
    String descripcion;
    String urlImagen;
    String ubicacion;
    String fecha;

    public  Campaña(){

    }

    public Campaña(String titulo, String descripcion, String urlImagen, String ubicacion, String fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

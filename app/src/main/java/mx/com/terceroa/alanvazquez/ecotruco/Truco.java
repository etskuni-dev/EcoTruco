package mx.com.terceroa.alanvazquez.ecotruco;

/**
 * Created by AlanVazquez on 10/04/17.
 */

public class Truco {


    String titulo;
    String dificultad;
    int tiempo;
    String urlImagen;
    String descripcion;

    public Truco(){

    }

    public Truco( String titulo, String dificultad, int tiempo, String urlImagen, String descripcion){
        this.titulo = titulo;
        this.dificultad = dificultad;
        this.tiempo = tiempo;
        this.urlImagen = urlImagen;
        this.descripcion = descripcion;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

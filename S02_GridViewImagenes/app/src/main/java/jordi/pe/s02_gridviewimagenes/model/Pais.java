package jordi.pe.s02_gridviewimagenes.model;

public class Pais {

    private String nombre;
    private int imagen;

    public Pais(String nombre, int imagen){
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }
}

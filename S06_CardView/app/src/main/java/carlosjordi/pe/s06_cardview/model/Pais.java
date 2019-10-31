package carlosjordi.pe.s06_cardview.model;

public class Pais {

    private String nombre, descripcion;
    private int bandera;

    public Pais() {
    }

    public Pais(String nombre, String descripcion, int bandera) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.bandera = bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
}

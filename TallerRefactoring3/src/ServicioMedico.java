public class ServicioMedico {
    private String nombre;
    private String descripcion;
    private double costo;
    private int duracion;

    public ServicioMedico(String nombre, String descripcion, double costo, int duracion) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCosto(costo);
        this.setDuracion(duracion);
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

    public double getCosto() {
        return costo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setCosto(double costo) {
        if(costo<0){
            throw new IllegalArgumentException("El valor no puede ser menor a cero");
        }
        this.costo = costo;
    }

    public void setDuracion(int duracion) {
        if (costo < 0) {
            throw new IllegalArgumentException("El valor no puede ser menor a cero");
        }
        this.duracion = duracion;
    }
}

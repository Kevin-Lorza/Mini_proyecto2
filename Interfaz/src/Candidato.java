public class Candidato {
    private String nombre;
    private String cedula;
    private String ciudad;
    private String posicion;
    private String partido;
    private int votos;
    private String propuestas;

    public Candidato(String nombre, String cedula, String ciudad, String posicion, String partido, int votos, String propuestas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.posicion = posicion;
        this.partido = partido;
        this.votos = votos;
        this.propuestas = propuestas;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nCédula: " + cedula +
                "\nCiudad: " + ciudad +
                "\nPosición: " + posicion +
                "\nPartido: " + partido +
                "\nVotos: " + votos +
                "\nPropuestas: " + propuestas;
    }
}

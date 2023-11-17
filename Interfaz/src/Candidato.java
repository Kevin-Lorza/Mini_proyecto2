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
    

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCedula() {
        return cedula;
    }


    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public String getCiudad() {
        return ciudad;
    }


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public String getPosicion() {
        return posicion;
    }


    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }


    public String getPartido() {
        return partido;
    }


    public void setPartido(String partido) {
        this.partido = partido;
    }


    public int getVotos() {
        return votos;
    }


    public void setVotos(int votos) {
        this.votos = votos;
    }


    public String getPropuestas() {
        return propuestas;
    }


    public void setPropuestas(String propuestas) {
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

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre.trim();
        this.sintoma = sintoma.trim();
        this.codigoEmergencia = codigoEmergencia;
    }

    public String getNombre() { return nombre; }
    public String getSintoma() { return sintoma; }
    public char getCodigoEmergencia() { return codigoEmergencia; }

    @Override
    public int compareTo(Paciente otroPaciente) {
        return Character.compare(this.codigoEmergencia, otroPaciente.getCodigoEmergencia());
    }
    
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
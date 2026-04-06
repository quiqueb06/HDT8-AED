import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MainPriority {
    public static void main(String[] args) {
        
        PriorityQueue<Paciente> colaEmergencias = new PriorityQueue<>();

        System.out.println("SISTEMA DE EMERGENCIAS ");
        System.out.println("Leyendo archivo de pacientes...");

        try {
            File archivo = new File("pacientes.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");

                if (datos.length == 3) {
                    String nombre = datos[0];
                    String sintoma = datos[1];
                    char codigo = datos[2].trim().charAt(0); 

                    Paciente paciente = new Paciente(nombre, sintoma, codigo);
                    colaEmergencias.add(paciente);
                }
            }
            scanner.close();
            System.out.println("Pacientes registrados correctamente");

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo 'pacientes.txt'.");
            return; 
        }

        System.out.println("ORDEN DE ATENCIÓN DE PACIENTES ");
        
        while (!colaEmergencias.isEmpty()) {
            Paciente pacienteAtendido = colaEmergencias.poll();
            
            System.out.println("Atendiendo a: " + pacienteAtendido.getNombre() + 
                               " Síntoma: " + pacienteAtendido.getSintoma() + 
                               " Prioridad: " + pacienteAtendido.getCodigoEmergencia());
        }
        
        System.out.println("Ya no hay pacientes en la sala de espera.");
    }
}
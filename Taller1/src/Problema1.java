//Andres Mauricio Moreno Garavito - Programación orientada a Objetos - Uniminuto
import java.util.Scanner;

public class Problema1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Introducción al programa de consulta de matriculas LG.
            System.out.println("Bienvenido al sistema de consulta de matrícula para estudiantes");
            System.out.println("Este software le permitirá conocer el valor de su proxima matricula \n");

            // Acceso a las carreras disponibles (se da una cantidad de semestres a cada carrera).
            Carrera[] carreras = {
                    new Carrera("Artes", 10),
                    new Carrera("Medicina", 12),
                    new Carrera("Derecho", 8),
                    new Carrera("Música",10),
                    new Carrera("Ingenieria de sistemas",10),
                    new Carrera("Administración Financiera",8)
            };
            // De acuerdo a la asignación del listado se espera la respuesta del usuario.
            System.out.println("Seleccione una carrera:");
            for (int i = 0; i < carreras.length; i++) {
                System.out.println((i + 1) + ". " + carreras[i].getNombre());
            }
            int opcionCarrera = scanner.nextInt();
            scanner.nextLine();
            Carrera carreraSeleccionada = carreras[opcionCarrera - 1];

            // Aqui solicitamos los datos de los estudiantes y almacenamos.
            System.out.print("Por favor ingrese los datos solicitados \n");
            System.out.print("Nombres: ");
            String nombres = scanner.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();
            System.out.print("Numero de documento: ");
            String documento = scanner.nextLine();
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            Estudiante estudiante = new Estudiante(nombres, apellidos, documento, direccion, telefono);

            // Aquí solicitamos datos necesarios para el calculo y generación del recibo.

            System.out.print("¿Es curso en línea? (si/no): ");
            String enLineaInput = scanner.nextLine().toLowerCase();
            boolean enLinea = enLineaInput.equals("si");

            System.out.print("Ingrese el semestre actual: ");
            int semestre = scanner.nextInt();
            System.out.print("Ingrese el número de materias perdidas: ");
            int materiasPerdidas = scanner.nextInt();

            Matricula matricula = new Matricula(estudiante, carreraSeleccionada, enLinea, semestre, materiasPerdidas);

            // Impresión del recibo
            matricula.imprimirRecibo();

            scanner.nextLine();

            // Preguntamos si se requiere otra consulta
            System.out.print("¿Desea realizar otra consulta? (si/no): ");
            String continuarInput = scanner.nextLine().toLowerCase();
            continuar = continuarInput.equals("si");

            System.out.println();
        }
            // Cerramos el programa
        System.out.println("Gracias por usar el sistema de consulta de matrícula para estudiantes ¡Hasta luego!");
        scanner.close();
    }
}

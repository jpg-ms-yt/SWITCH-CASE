import java.util.Scanner;

public class SistemaLogin {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String usuarioCorrecto = "admin";
        String contraseñaCorrecta = "12345";

        String usuario;
        String contraseña;

        int intentos = 0;

        System.out.println("=== SISTEMA DE LOGIN ===");

        while (intentos < 3) {

            System.out.print("Ingrese usuario: ");
            usuario = teclado.nextLine();

            System.out.print("Ingrese contraseña: ");
            contraseña = teclado.nextLine();

            // Validación
            if (usuario.equals(usuarioCorrecto) &&
                contraseña.equals(contraseñaCorrecta)) {

                System.out.println("Inicio de sesión exitoso");
                break;

            } else {

                intentos++;

                System.out.println("Usuario o contraseña incorrectos");

                if (intentos < 3) {
                    System.out.println("Intentos restantes: " + (3 - intentos));
                } else {
                    System.out.println("Cuenta bloqueada por demasiados intentos");
                }
            }
        }

        teclado.close();
    }
}
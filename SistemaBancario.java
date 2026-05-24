import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double saldo = 1000.0; // Saldo inicial
        int opcion;

        do {
            // 📋 MENÚ
            System.out.println("===== MENÚ DE SISTEMA BANCARIO =====");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");
            System.out.print("Elige una opción (1-4): ");
            opcion = entrada.nextInt();

            // 🔄 SWITCH (tal como lo pediste)
            switch (opcion) {
                case 1: // DEPOSITAR
                    System.out.println("\n--- Realizar depósito ---");
                    System.out.print("Ingresa el monto a depositar: ");
                    double deposito = entrada.nextDouble();

                    // ⚠️ Validación: monto inválido
                    if (deposito <= 0) {
                        System.out.println("❌ Error: Monto inválido. Debe ser mayor a 0.");
                    } else {
                        saldo += deposito;
                        System.out.printf("✅ Depósito realizado. Nuevo saldo: S/ %.2f%n", saldo);
                    }
                    break;

                case 2: // RETIRAR
                    System.out.println("\n--- Realizar retiro ---");
                    System.out.print("Ingresa el monto a retirar: ");
                    double retiro = entrada.nextDouble();

                    // ⚠️ Validación 1: monto inválido
                    if (retiro <= 0) {
                        System.out.println("❌ Error: Monto inválido. Debe ser mayor a 0.");
                    }
                    // ⚠️ Validación 2: saldo insuficiente
                    else if (retiro > saldo) {
                        System.out.println("❌ Error: Saldo insuficiente. No puedes retirar más de lo que tienes.");
                    } else {
                        saldo -= retiro;
                        System.out.printf("✅ Retiro realizado. Nuevo saldo: S/ %.2f%n", saldo);
                    }
                    break;

                case 3: // CONSULTAR SALDO
                    System.out.println("\n--- Consultar saldo ---");
                    System.out.printf("💰 Tu saldo actual es: S/ %.2f%n", saldo);
                    break;

                case 4: // SALIR
                    System.out.println("👋 Gracias por usar el sistema bancario. ¡Hasta luego!");
                    break;

                default: // OPCIÓN INCORRECTA
                    System.out.println("⚠️ Opción no válida. Elige un número entre 1 y 4.");
            }

            System.out.println("\n------------------------------------\n");

        } while (opcion != 4); // Se repite hasta elegir salir

        entrada.close();
    }
}
import java.util.Scanner;

public class ConversorUnidades {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        double valor, resultado;

        do {
            // 📋 MENÚ DE OPCIONES
            System.out.println("===== CONVERSOR DE UNIDADES =====");
            System.out.println("1. Metros a Kilómetros");
            System.out.println("2. Kilómetros a Metros");
            System.out.println("3. Celsius a Fahrenheit");
            System.out.println("4. Fahrenheit a Celsius");
            System.out.println("5. Salir");
            System.out.print("Elige una opción (1-5): ");
            opcion = entrada.nextInt();

            // 🔄 SWITCH para elegir la fórmula
            switch (opcion) {
                case 1: // Metros a Kilómetros
                    System.out.println("\n--- Metros a Kilómetros ---");
                    System.out.print("Ingresa el valor en metros: ");
                    valor = entrada.nextDouble();
                    resultado = valor / 1000; // Fórmula
                    System.out.printf("✅ Resultado: %.2f metros = %.2f kilómetros%n", valor, resultado);
                    break;

                case 2: // Kilómetros a Metros
                    System.out.println("\n--- Kilómetros a Metros ---");
                    System.out.print("Ingresa el valor en kilómetros: ");
                    valor = entrada.nextDouble();
                    resultado = valor * 1000; // Fórmula
                    System.out.printf("✅ Resultado: %.2f kilómetros = %.2f metros%n", valor, resultado);
                    break;

                case 3: // Celsius a Fahrenheit
                    System.out.println("\n--- Celsius a Fahrenheit ---");
                    System.out.print("Ingresa la temperatura en Celsius: ");
                    valor = entrada.nextDouble();
                    resultado = (valor * 1.8) + 32; // Fórmula: (C × 1.8) + 32
                    System.out.printf("✅ Resultado: %.2f °C = %.2f °F%n", valor, resultado);
                    break;

                case 4: // Fahrenheit a Celsius
                    System.out.println("\n--- Fahrenheit a Celsius ---");
                    System.out.print("Ingresa la temperatura en Fahrenheit: ");
                    valor = entrada.nextDouble();
                    resultado = (valor - 32) / 1.8; // Fórmula: (F - 32) ÷ 1.8
                    System.out.printf("✅ Resultado: %.2f °F = %.2f °C%n", valor, resultado);
                    break;

                case 5: // Salir
                    System.out.println("👋 Programa finalizado. ¡Hasta luego!");
                    break;

                default: // Opción incorrecta
                    System.out.println("⚠️ Opción inválida. Elige un número entre 1 y 5.");
            }

            System.out.println("\n------------------------------------\n");

        } while (opcion != 5); // Se repite hasta elegir salir

        entrada.close();
    }
}
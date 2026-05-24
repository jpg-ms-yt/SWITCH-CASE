import javax.swing.*;

public class OperacionesLogicas {
    public static void main(String[] args) {
        // 📝 CÓDIGO ORIGINAL TAL CUAL LO TÚ LO TENÍAS EN LA IMAGEN
        System.out.println("Operador AND (&&):");
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);
        System.out.println();

        System.out.println("Operador OR (||):");
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false); // Línea que tú agregaste
        System.out.println();

        System.out.println("Operador NOT (!):");
        System.out.println(!true);
        System.out.println(!false);

        // ✨ PARTE NUEVA: Evaluador interactivo con SWITCH (String)
        try {
            // 1. Pedir operador al usuario
            String operador = JOptionPane.showInputDialog(null,
                    "Ingresa el operador a evaluar:\n\nAND  |  OR  |  XOR",
                    "Evaluador de Operaciones Lógicas 🇵🇪",
                    JOptionPane.QUESTION_MESSAGE);

            if (operador == null) return; // Si cancela, salimos
            operador = operador.toUpperCase().trim(); // Acepta mayúsculas/minúsculas

            // 2. Pedir primer valor
            String entrada1 = JOptionPane.showInputDialog(null,
                    "Ingresa el primer valor:\n( true  /  false )",
                    "Valor Booleano 1",
                    JOptionPane.QUESTION_MESSAGE);
            boolean valor1 = Boolean.parseBoolean(entrada1.toLowerCase().trim());

            // 3. Pedir segundo valor
            String entrada2 = JOptionPane.showInputDialog(null,
                    "Ingresa el segundo valor:\n( true  /  false )",
                    "Valor Booleano 2",
                    JOptionPane.QUESTION_MESSAGE);
            boolean valor2 = Boolean.parseBoolean(entrada2.toLowerCase().trim());

            boolean resultado = false;
            String explicacion = "";

            // 🔄 SWITCH CON STRING (tal como te pidieron)
            switch (operador) {
                case "AND":
                    resultado = valor1 && valor2;
                    explicacion = "📘 AND: Solo es VERDADERO si AMBOS son verdaderos";
                    break;

                case "OR":
                    resultado = valor1 || valor2;
                    explicacion = "📙 OR: Es VERDADERO si AL MENOS UNO es verdadero";
                    break;

                case "XOR":
                    resultado = valor1 ^ valor2; // Operador XOR en Java
                    explicacion = "📗 XOR: Es VERDADERO SOLO si son DIFERENTES entre sí";
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "❌ Operador NO VÁLIDO\nUsa solo: AND, OR o XOR",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }

            // 📊 Mostrar resultado final
            String mensajeFinal = "=== RESULTADO DE LA OPERACIÓN ===\n\n" +
                    "🔎 Operación: " + operador + "\n" +
                    "📥 Valor 1: " + valor1 + "\n" +
                    "📥 Valor 2: " + valor2 + "\n" +
                    "--------------------------------\n" +
                    "📤 RESULTADO: " + resultado + "\n\n" +
                    explicacion + "\n\n" +
                    "🇵🇪 Sistema desarrollado en Lima - Perú";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Operaciones Lógicas 🇵🇪", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Error: Ingresa únicamente valores: true o false",
                    "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
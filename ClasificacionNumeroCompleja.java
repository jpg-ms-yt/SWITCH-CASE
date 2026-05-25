import javax.swing.JOptionPane;

public class ClasificacionNumeroCompleja {
    public static void main(String[] args) {
        // 📥 Pedir número al usuario
        String numeroStr = JOptionPane.showInputDialog(null,
                "Ingrese un número entero:",
                "Clasificación de Número", JOptionPane.QUESTION_MESSAGE);

        // ✅ Validación si cancela
        if (numeroStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 Convertir a número entero
            int numero = Integer.parseInt(numeroStr.trim());
            String resultado = "";

            // 🔴 1. CLASIFICAR: POSITIVO, NEGATIVO O CERO (SOLO IF)
            String signo = "";

            if (numero > 0) {
                signo = "✅ El número es POSITIVO";
            }
            if (numero < 0) {
                signo = "❌ El número es NEGATIVO";
            }
            if (numero == 0) {
                signo = "⚫ El número es CERO";
            }

            // 🔴 2. CLASIFICAR: PAR O IMPAR (SOLO IF)
            String paridad = "";
            int valorAbsoluto = Math.abs(numero); // Para que funcione con negativos

            if (valorAbsoluto % 2 == 0) {
                paridad = "🔢 Y además es un número PAR";
            }
            if (valorAbsoluto % 2 != 0) {
                paridad = "🔢 Y además es un número IMPAR";
            }

            // 📤 MOSTRAR RESULTADO FINAL
            resultado = "==================================\n" +
                        "📊 CLASIFICACIÓN DEL NÚMERO: " + numero + "\n" +
                        "==================================\n" +
                        signo + "\n" +
                        paridad + "\n" +
                        "==================================";

            JOptionPane.showMessageDialog(null, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo un número entero válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
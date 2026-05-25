import javax.swing.JOptionPane;

public class EvaluadorNumerosComplejos {
    public static void main(String[] args) {
        // 📥 INGRESAR NÚMERO
        String numeroStr = JOptionPane.showInputDialog(null,
                "Ingrese un número entero para evaluar:",
                "Evaluador de Números", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN: Si cancela
        if (numeroStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR A ENTERO
            int numero = Integer.parseInt(numeroStr.trim());
            String resultado = "";
            String signo = "";
            String paridad = "";
            String multiplos = "";

            // 🔴 1. DETERMINAR SIGNO: POSITIVO, NEGATIVO O CERO
            if (numero > 0) {
                signo = "✅ El número es POSITIVO";
            } else {
                if (numero < 0) {
                    signo = "❌ El número es NEGATIVO";
                } else {
                    signo = "⚫ El número es CERO (neutro)";
                }
            }

            // 🔴 2. DETERMINAR SI ES PAR O IMPAR
            // Primero evaluamos si NO es cero, porque el cero es par matemáticamente
            if (numero != 0) {
                if (numero % 2 == 0) {
                    paridad = "🔢 Es un número PAR";
                } else {
                    paridad = "🔢 Es un número IMPAR";
                }
            } else {
                paridad = "🔢 El cero se considera PAR";
            }

            // 🔴 3. DETERMINAR SI ES MÚLTIPLO DE 3, 5, AMBOS O NINGUNO
            // Usamos Math.abs() para que funcione también con números negativos
            int valorAbsoluto = Math.abs(numero);

            if (valorAbsoluto == 0) {
                multiplos = "➗ El cero es múltiplo de todos los números";
            } else {
                if (valorAbsoluto % 3 == 0 && valorAbsoluto % 5 == 0) {
                    multiplos = "➗ Es múltiplo de 3 y también de 5";
                } else {
                    if (valorAbsoluto % 3 == 0) {
                        multiplos = "➗ Es múltiplo de 3";
                    } else {
                        if (valorAbsoluto % 5 == 0) {
                            multiplos = "➗ Es múltiplo de 5";
                        } else {
                            multiplos = "➗ No es múltiplo ni de 3 ni de 5";
                        }
                    }
                }
            }

            // 📤 COMBINAMOS Y MOSTRAMOS TODOS LOS RESULTADOS
            resultado = "==================================\n" +
                        "📊 EVALUACIÓN DEL NÚMERO: " + numero + "\n" +
                        "==================================\n" +
                        signo + "\n" +
                        paridad + "\n" +
                        multiplos + "\n" +
                        "==================================";

            JOptionPane.showMessageDialog(null, resultado, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo un número entero válido.",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}
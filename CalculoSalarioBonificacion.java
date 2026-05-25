import javax.swing.JOptionPane;

public class CalculoSalarioBonificacion {
    public static void main(String[] args) {
        // 📥 PEDIR DATOS AL USUARIO
        String salarioStr = JOptionPane.showInputDialog(null,
                "Ingrese el salario mensual del trabajador:",
                "Cálculo de Bonificación", JOptionPane.QUESTION_MESSAGE);

        String aniosStr = JOptionPane.showInputDialog(null,
                "Ingrese los años de antigüedad en la empresa:",
                "Cálculo de Bonificación", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN SI CANCELA (SOLO IF)
        if (salarioStr == null || aniosStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR A NÚMEROS
            double salario = Double.parseDouble(salarioStr.trim());
            int anios = Integer.parseInt(aniosStr.trim());
            double bono = 0.0;
            String tipoBono = "✅ SIN BONIFICACIÓN";

            // 🔴 LÓGICA EXACTA PEDIDA - SOLO CON IF

            // CASO 1: Si años > 5 Y salario < 2000 → BONO COMPLETO
            if (anios > 5 && salario < 2000) {
                bono = salario * 0.15; // Ejemplo: 15% de bono
                tipoBono = "🎉 BONO COMPLETO APLICADO (15%)\n→ Cumple antigüedad y salario requerido";
            }

            // CASO 2: Si SOLO cumple UNA de las dos condiciones → BONO MENOR
            // (Es decir: O tiene más de 5 años pero gana 2000 o más, O gana menos de 2000 pero tiene 5 años o menos)
            if ( (anios > 5 && salario >= 2000) || (anios <= 5 && salario < 2000) ) {
                bono = salario * 0.05; // Ejemplo: 5% de bono
                tipoBono = "✨ BONO MENOR APLICADO (5%)\n→ Solo cumple uno de los requisitos";
            }

            // CASO 3: Si NO cumple ninguna → SIN BONO
            // (Tiene 5 años o menos Y gana 2000 o más)
            if (anios <= 5 && salario >= 2000) {
                bono = 0.0;
                tipoBono = "❌ SIN BONIFICACIÓN\n→ No cumple ninguno de los requisitos";
            }

            // 🧮 CÁLCULO FINAL
            double salarioTotal = salario + bono;

            // 📤 MOSTRAR RESULTADO
            String mensajeFinal = "=========================================\n" +
                                  "💲 RESUMEN DE PAGO\n" +
                                  "=========================================\n" +
                                  "Salario base:         S/ " + String.format("%.2f", salario) + "\n" +
                                  "Años de antigüedad:   " + anios + " años\n" +
                                  "-----------------------------------------\n" +
                                  tipoBono + "\n" +
                                  "Valor del bono:       S/ " + String.format("%.2f", bono) + "\n" +
                                  "-----------------------------------------\n" +
                                  "💰 SALARIO TOTAL:     S/ " + String.format("%.2f", salarioTotal) + "\n" +
                                  "=========================================";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Detalle de Nómina", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ ERROR: Ingrese solo números válidos.\n(No escriba letras ni símbolos)",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
    }
}
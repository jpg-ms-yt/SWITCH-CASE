import javax.swing.JOptionPane;

public class SistemaTarifasTransporte {
    public static void main(String[] args) {
        // 📥 ENTRADA DE DATOS
        String distanciaStr = JOptionPane.showInputDialog(null,
                "Ingrese la distancia recorrida (en kilómetros):",
                "Sistema de Tarifas", JOptionPane.QUESTION_MESSAGE);

        String tipoUsuarioStr = JOptionPane.showInputDialog(null,
                "Ingrese tipo de usuario:\n- estudiante\n- adulto\n- adulto mayor",
                "Sistema de Tarifas", JOptionPane.QUESTION_MESSAGE);

        String horarioStr = JOptionPane.showInputDialog(null,
                "Ingrese horario del viaje:\n- normal\n- nocturno",
                "Sistema de Tarifas", JOptionPane.QUESTION_MESSAGE);

        // ✅ VALIDACIÓN: Si cancela algún cuadro
        if (distanciaStr == null || tipoUsuarioStr == null || horarioStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 🔄 CONVERTIR Y LIMPIAR DATOS
            double distancia = Double.parseDouble(distanciaStr.trim());
            String tipoUsuario = tipoUsuarioStr.trim().toLowerCase();
            String horario = horarioStr.trim().toLowerCase();

            // ✅ VALIDACIÓN DE DATOS
            if (distancia <= 0) {
                JOptionPane.showMessageDialog(null, "❌ La distancia debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!tipoUsuario.equals("estudiante") && !tipoUsuario.equals("adulto") && !tipoUsuario.equals("adulto mayor")) {
                JOptionPane.showMessageDialog(null, "❌ Tipo de usuario inválido.\nSolo: estudiante, adulto, adulto mayor.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!horario.equals("normal") && !horario.equals("nocturno")) {
                JOptionPane.showMessageDialog(null, "❌ Horario inválido.\nSolo: normal o nocturno.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 💲 VARIABLES BASE
            double tarifaBase = 2.00; // Tarifa inicial
            double costoPorKm = 1.50; // Costo por cada kilómetro
            double descuento = 0.0;
            double recargoNocturno = 0.0;
            double costoTotal;
            String detalles = "";

            // 🔴 LÓGICA COMPLEJA CON IF - ELSE (TODO AQUÍ DENTRO)

            // PASO 1: Calcular costo base por distancia
            costoTotal = tarifaBase + (distancia * costoPorKm);
            detalles += "Costo base: S/ " + String.format("%.2f", costoTotal) + "\n";

            // PASO 2: APLICAR RECARGO POR HORARIO NOCTURNO (20% más)
            if (horario.equals("nocturno")) {
                recargoNocturno = costoTotal * 0.20;
                costoTotal += recargoNocturno;
                detalles += "Recargo nocturno (+20%): S/ " + String.format("%.2f", recargoNocturno) + "\n";
            } else {
                detalles += "Horario normal: Sin recargo\n";
            }

            // PASO 3: APLICAR DESCUENTOS SEGÚN USUARIO + REGLAS ADICIONALES
            if (tipoUsuario.equals("estudiante")) {
                // Estudiante: 50% descuento SIEMPRE, pero si es NOCTURNO solo 30%
                if (horario.equals("nocturno")) {
                    descuento = costoTotal * 0.30;
                    detalles += "Descuento Estudiante (Nocturno - 30%): -S/ " + String.format("%.2f", descuento) + "\n";
                } else {
                    descuento = costoTotal * 0.50;
                    detalles += "Descuento Estudiante (Normal - 50%): -S/ " + String.format("%.2f", descuento) + "\n";
                }

                // REGLA EXTRA: Si recorre más de 20km → Descuento extra 10%
                if (distancia > 20) {
                    double descuentoExtra = costoTotal * 0.10;
                    descuento += descuentoExtra;
                    detalles += "→ Descuento por distancia larga: -S/ " + String.format("%.2f", descuentoExtra) + "\n";
                }
            } 
            else if (tipoUsuario.equals("adulto mayor")) {
                // Adulto Mayor: 40% descuento fijo, SIN importar horario
                descuento = costoTotal * 0.40;
                detalles += "Descuento Adulto Mayor (40%): -S/ " + String.format("%.2f", descuento) + "\n";

                // REGLA EXTRA: Si distancia MENOR a 5km → ¡VIAJE GRATIS!
                if (distancia < 5) {
                    costoTotal = 0.0;
                    descuento = 0.0; // Reiniciamos porque es gratis
                    detalles += "→ ¡Viaje menor a 5km: TOTALMENTE GRATIS!\n";
                }
            } 
            else if (tipoUsuario.equals("adulto")) {
                // Adulto: SIN descuento, PERO si recorre más de 15km → 15% descuento
                if (distancia > 15) {
                    descuento = costoTotal * 0.15;
                    detalles += "Descuento por distancia larga (>15km - 15%): -S/ " + String.format("%.2f", descuento) + "\n";
                } else {
                    detalles += "Usuario Adulto: Sin descuentos aplicables\n";
                }
            }

            // 🧮 CÁLCULO FINAL
            if (costoTotal > 0) { // Solo restamos descuento si no es viaje gratis
                costoTotal -= descuento;
            }

            // 📤 MOSTRAR RESULTADO
            String mensajeFinal = "=========================================\n" +
                                  "📋 SISTEMA DE TARIFAS DE TRANSPORTE\n" +
                                  "=========================================\n" +
                                  "Distancia: " + distancia + " km\n" +
                                  "Tipo Usuario: " + tipoUsuario.toUpperCase() + "\n" +
                                  "Horario: " + horario.toUpperCase() + "\n" +
                                  "-----------------------------------------\n" +
                                  detalles +
                                  "-----------------------------------------\n" +
                                  "💰 TOTAL A PAGAR: S/ " + String.format("%.2f", costoTotal) + "\n" +
                                  "=========================================";

            JOptionPane.showMessageDialog(null, mensajeFinal, "Resumen de Tarifa", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ ERROR: Ingrese solo números válidos en la distancia.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
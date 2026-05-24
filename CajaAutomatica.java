import javax.swing.*;

public class CajaAutomatica {
    public static void main(String[] args) {
        // DATOS INICIALES
        final int PIN_CORRECTO = 1234; // PIN por defecto
        double saldo = 1500.00;        // Saldo inicial
        final double LIMITE_DIARIO = 500.00; // Límite de retiro diario
        int intentosRestantes = 3;     // Máximo 3 intentos
        boolean accesoPermitido = false;

        // 🔑 VALIDACIÓN DE PIN (3 INTENTOS)
        while (intentosRestantes > 0) {
            String entradaPin = JOptionPane.showInputDialog(null,
                    "=== CAJA AUTOMÁTICA ===\n" +
                    "Ingrese su PIN de 4 dígitos:\n" +
                    "Intentos restantes: " + intentosRestantes,
                    "Validación de Acceso", JOptionPane.QUESTION_MESSAGE);

            // Si cancela el programa
            if (entradaPin == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            try {
                int pinIngresado = Integer.parseInt(entradaPin.trim());

                // ✅ USO DE IF-ELSE PARA VALIDAR PIN
                if (pinIngresado == PIN_CORRECTO) {
                    accesoPermitido = true;
                    break; // PIN correcto, salimos del bucle
                } else {
                    intentosRestantes--;
                    // Aviso si aún quedan intentos
                    if (intentosRestantes > 0) {
                        JOptionPane.showMessageDialog(null,
                                "❌ PIN INCORRECTO\n" +
                                "Le quedan " + intentosRestantes + " intento(s).",
                                "Error de Seguridad", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese solo números.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // 🔒 Si agotó los 3 intentos
        if (!accesoPermitido) {
            JOptionPane.showMessageDialog(null,
                    "🚫 TARJETA BLOQUEADA\nHa superado los 3 intentos permitidos.",
                    "ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
            return; // Fin del programa
        }

        // 🏦 MENÚ PRINCIPAL
        int opcion;
        do {
            String menu = "===== MENÚ CAJA AUTOMÁTICA =====\n" +
                    "1. Verificar saldo\n" +
                    "2. Retirar dinero\n" +
                    "3. Salir\n\n" +
                    "Ingrese una opción:";

            String opcionStr = JOptionPane.showInputDialog(menu);
            if (opcionStr == null) break; // Cancelar

            try {
                opcion = Integer.parseInt(opcionStr.trim());

                switch (opcion) {
                    case 1:
                        // 💵 CONSULTAR SALDO
                        JOptionPane.showMessageDialog(null,
                                "📊 SALDO ACTUAL\nS/ " + String.format("%.2f", saldo),
                                "Consulta de Saldo", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 2:
                        // 💸 RETIRAR DINERO
                        String montoStr = JOptionPane.showInputDialog(null,
                                "Ingrese el monto a retirar (S/):\n" +
                                "Límite diario: S/ " + LIMITE_DIARIO,
                                "Retiro de Efectivo", JOptionPane.QUESTION_MESSAGE);

                        if (montoStr == null) break;
                        double monto = Double.parseDouble(montoStr.trim());

                        // ✅ IF-ELSE PARA REGLAS DE NEGOCIO
                        if (monto <= 0) {
                            JOptionPane.showMessageDialog(null, "Ingrese un monto mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (monto > LIMITE_DIARIO) {
                            // ❌ SUPERA LÍMITE DIARIO
                            JOptionPane.showMessageDialog(null,
                                    "⚠️ LÍMITE DIARIO EXCEDIDO\nEl máximo permitido es S/ " + LIMITE_DIARIO,
                                    "Operación no permitida", JOptionPane.WARNING_MESSAGE);
                        } else if (monto > saldo) {
                            // ❌ FONDOS INSUFICIENTES
                            JOptionPane.showMessageDialog(null,
                                    "❌ FONDOS INSUFICIENTES\nNo tiene suficiente saldo para esta operación.",
                                    "Saldo insuficiente", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // ✅ OPERACIÓN EXITOSA
                            saldo -= monto;
                            JOptionPane.showMessageDialog(null,
                                    "✅ RETIRO EXITOSO\n" +
                                    "Retiraste: S/ " + String.format("%.2f", monto) + "\n" +
                                    "Nuevo saldo: S/ " + String.format("%.2f", saldo),
                                    "Comprobante", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Gracias por usar la Caja Automática.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida (1-3)", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese solo números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                opcion = 0;
            }

        } while (opcion != 3);
    }
}
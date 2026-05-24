import javax.swing.*;
import java.awt.*;

public class ProgramaEstacionamiento extends JFrame {
    public ProgramaEstacionamiento() {
        setTitle("Tarifa de Estacionamiento - Lima");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 📋 DATOS Y COMPONENTES
        JLabel etiquetaVehiculo = new JLabel("Seleccione tipo de vehículo:");
        String[] tipos = {"Moto", "Auto", "Camión"};
        JComboBox<String> cboVehiculo = new JComboBox<>(tipos);

        JLabel etiquetaHoras = new JLabel("Ingrese cantidad de horas de uso:");
        JTextField campoHoras = new JTextField(5);

        JButton btnCalcular = new JButton("Calcular Tarifa");
        JTextArea areaResultado = new JTextArea(8, 35);
        areaResultado.setEditable(false);

        // ⚙️ LÓGICA PRINCIPAL
        btnCalcular.addActionListener(e -> {
            try {
                // 1. Obtener datos ingresados
                String vehiculo = (String) cboVehiculo.getSelectedItem();
                int horas = Integer.parseInt(campoHoras.getText().trim());
                double tarifaBase = 0.0;
                double total = 0.0;

                // 🔄 SWITCH: Definimos tarifa según vehículo (Precios referenciales Lima)
                switch (vehiculo) {
                    case "Moto":
                        tarifaBase = 2.00; // S/ 2.00 por hora
                        break;
                    case "Auto":
                        tarifaBase = 4.00; // S/ 4.00 por hora
                        break;
                    case "Camión":
                        tarifaBase = 7.00; // S/ 7.00 por hora
                        break;
                    default:
                        areaResultado.setText("❌ Tipo de vehículo no válido");
                        return;
                }

                // 📉 IF: Cálculo final y reglas de descuento
                if (horas <= 0) {
                    areaResultado.setText("⚠️ Error: Las horas deben ser mayor a 0");
                    return;
                } 
                else if (horas <= 2) {
                    // Tarifa normal para estancias cortas
                    total = tarifaBase * horas;
                    areaResultado.setText("📌 Tarifa: Precio normal\n");
                } 
                else if (horas <= 5) {
                    // 10% de descuento por estar más de 2 horas
                    total = (tarifaBase * horas) * 0.90;
                    areaResultado.setText("🎁 Beneficio: 10% descuento (2 a 5 horas)\n");
                } 
                else {
                    // 20% de descuento por estar más de 5 horas
                    total = (tarifaBase * horas) * 0.80;
                    areaResultado.setText("🎁 Beneficio: 20% descuento (más de 5 horas)\n");
                }

                // 📄 MOSTRAMOS EL RESUMEN
                String resumen = "=====================================\n" +
                                 "🚗 Vehículo: " + vehiculo + "\n" +
                                 "⏱️ Tiempo: " + horas + " hora(s)\n" +
                                 "💲 Tarifa por hora: S/ " + String.format("%.2f", tarifaBase) + "\n" +
                                 "-------------------------------------\n" +
                                 "💰 TOTAL A PAGAR: S/ " + String.format("%.2f", total) + "\n" +
                                 "=====================================";

                areaResultado.append(resumen);

            } catch (NumberFormatException ex) {
                areaResultado.setText("❌ Error: Ingrese solo números válidos en las horas");
            }
        });

        // AGREGAMOS AL MARCO
        add(etiquetaVehiculo);
        add(cboVehiculo);
        add(etiquetaHoras);
        add(campoHoras);
        add(btnCalcular);
        add(new JScrollPane(areaResultado));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProgramaEstacionamiento());
    }
}
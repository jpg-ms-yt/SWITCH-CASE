import javax.swing.*;
import java.awt.*;

public class ClasificacionRiesgo extends JFrame {
    public ClasificacionRiesgo() {
        setTitle("Clasificación de Riesgo Crediticio");
        setSize(400, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de entrada
        JLabel lIngreso = new JLabel("Ingreso mensual (S/):");
        JTextField txtIngreso = new JTextField(10);

        JLabel lHistorial = new JLabel("Historial crediticio (bueno / regular / malo):");
        JTextField txtHistorial = new JTextField(15);

        JLabel lEdad = new JLabel("Edad del cliente:");
        JTextField txtEdad = new JTextField(5);

        JButton btnEvaluar = new JButton("Evaluar Riesgo");
        JTextArea areaResultado = new JTextArea(8, 30);
        areaResultado.setEditable(false);

        // LÓGICA CON IF - ELSE ANIDADOS (tal como te pide)
        btnEvaluar.addActionListener(e -> {
            try {
                // Obtener y convertir datos
                double ingreso = Double.parseDouble(txtIngreso.getText().trim());
                String historial = txtHistorial.getText().trim().toLowerCase();
                int edad = Integer.parseInt(txtEdad.getText().trim());
                String riesgo = "";

                // ✅ AQUÍ ESTÁN LOS IF - ELSE ANIDADOS
                if (historial.equals("bueno")) {
                    // Si el historial es bueno, evaluamos ingreso y edad
                    if (ingreso > 3000) {
                        if (edad >= 25 && edad <= 60) {
                            riesgo = "BAJO"; // Muy confiable
                        } else {
                            riesgo = "BAJO"; // Sigue siendo bajo por ingreso alto
                        }
                    } else {
                        if (edad < 25 || edad > 60) {
                            riesgo = "MEDIO";
                        } else {
                            riesgo = "BAJO";
                        }
                    }
                } 
                else if (historial.equals("regular")) {
                    // Si el historial es regular
                    if (ingreso > 1500) {
                        if (edad >= 20 && edad <= 65) {
                            riesgo = "MEDIO";
                        } else {
                            riesgo = "ALTO";
                        }
                    } else {
                        riesgo = "ALTO";
                    }
                } 
                else if (historial.equals("malo")) {
                    // Si el historial es malo, el riesgo casi siempre es alto
                    if (ingreso > 5000) {
                        riesgo = "MEDIO"; // Excepción: gana mucho, aun así es medio
                    } else {
                        riesgo = "ALTO";
                    }
                } 
                else {
                    areaResultado.setText("Error: Historial solo puede ser: bueno, regular o malo");
                    return;
                }

                // Mostrar resultado final
                String resumen = "==================================\n" +
                                 "Ingreso mensual: S/ " + ingreso + "\n" +
                                 "Historial: " + historial.toUpperCase() + "\n" +
                                 "Edad: " + edad + " años\n" +
                                 "----------------------------------\n" +
                                 "CLASIFICACIÓN DE RIESGO: " + riesgo + "\n" +
                                 "==================================";

                areaResultado.setText(resumen);

            } catch (NumberFormatException ex) {
                areaResultado.setText("Error: Ingrese números válidos en ingreso y edad");
            }
        });

        // Agregar elementos
        add(lIngreso);
        add(txtIngreso);
        add(lHistorial);
        add(txtHistorial);
        add(lEdad);
        add(txtEdad);
        add(btnEvaluar);
        add(new JScrollPane(areaResultado));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClasificacionRiesgo());
    }
}
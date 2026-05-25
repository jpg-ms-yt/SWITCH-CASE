import javax.swing.*;
import java.awt.*;

public class ClasificaTriangulos4 extends JFrame {
    public ClasificaTriangulos4() {
        setTitle("Clasificación de Triángulos");
        setSize(380, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel lLado1 = new JLabel("Ingrese el primer lado:");
        JTextField txtLado1 = new JTextField(10);

        JLabel lLado2 = new JLabel("Ingrese el segundo lado:");
        JTextField txtLado2 = new JTextField(10);

        JLabel lLado3 = new JLabel("Ingrese el tercer lado:");
        JTextField txtLado3 = new JTextField(10);

        JButton btnClasificar = new JButton("Ver Tipo de Triángulo");
        JTextArea areaResultado = new JTextArea(8, 30);
        areaResultado.setEditable(false);

        btnClasificar.addActionListener(e -> {
            try {
                double lado1 = Double.parseDouble(txtLado1.getText().trim());
                double lado2 = Double.parseDouble(txtLado2.getText().trim());
                double lado3 = Double.parseDouble(txtLado3.getText().trim());
                String resultado = "";

                if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
                    resultado = "❌ INVÁLIDO\nLos lados deben ser mayores a 0.";
                } 
                else if ((lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1)) {
                    if (lado1 == lado2 && lado2 == lado3) {
                        resultado = "✅ TRIÁNGULO EQUILÁTERO\n→ Todos los lados iguales.";
                    } 
                    else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                        resultado = "✅ TRIÁNGULO ISÓSCELES\n→ Dos lados iguales.";
                    } 
                    else {
                        resultado = "✅ TRIÁNGULO ESCALENO\n→ Todos los lados distintos.";
                    }
                } 
                else {
                    resultado = "❌ NO ES UN TRIÁNGULO\nLa suma de dos lados debe ser mayor al tercero.";
                }

                String resumen = "==================================\n" +
                                 "Lado 1: " + lado1 + " | Lado 2: " + lado2 + " | Lado 3: " + lado3 + "\n" +
                                 "----------------------------------\n" +
                                 resultado + "\n" +
                                 "==================================";
                areaResultado.setText(resumen);

            } catch (NumberFormatException ex) {
                areaResultado.setText("❌ ERROR: Ingrese solo números válidos.");
            }
        });

        add(lLado1);
        add(txtLado1);
        add(lLado2);
        add(txtLado2);
        add(lLado3);
        add(txtLado3);
        add(btnClasificar);
        add(new JScrollPane(areaResultado));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClasificaTriangulos4());
    }
}
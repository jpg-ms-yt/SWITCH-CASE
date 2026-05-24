import javax.swing.*;
import java.awt.*;

public class Programa4DiasSemana extends JFrame {
    public Programa4DiasSemana() {
        setTitle("Días de la Semana");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes: igual que tu código original
        JLabel etiqueta = new JLabel("Ingresa un número (1 - 7):");
        JTextField campoNumero = new JTextField(5); // Donde escribes el número
        JButton botonMostrar = new JButton("Ver Día");
        JTextField resultado = new JTextField(20); // Donde se muestra el resultado
        resultado.setEditable(false); // Para que no se pueda editar

        // Acción del botón
        botonMostrar.addActionListener(e -> {
            try {
                // Leer y convertir el valor ingresado
                int numero = Integer.parseInt(campoNumero.getText().trim());
                String nombreDia;
                String tipoDia;

                // 🔄 SWITCH CON CASOS AGRUPADOS (tal como lo pediste)
                switch (numero) {
                    // Casos agrupados: días laborables
                    case 1, 2, 3, 4, 5:
                        // Asignamos nombre según el número
                        nombreDia = switch (numero) {
                            case 1 -> "Lunes";
                            case 2 -> "Martes";
                            case 3 -> "Miércoles";
                            case 4 -> "Jueves";
                            case 5 -> "Viernes";
                            default -> ""; // No se usa por la agrupación
                        };
                        tipoDia = "Día Laborable";
                        break;

                    // Casos agrupados: fin de semana
                    case 6, 7:
                        nombreDia = switch (numero) {
                            case 6 -> "Sábado";
                            case 7 -> "Domingo";
                            default -> "";
                        };
                        tipoDia = "Fin de Semana";
                        break;

                    // Si es un número fuera del rango 1-7
                    default:
                        resultado.setText("❌ Solo números del 1 al 7");
                        return; // Salimos para no mostrar nada más
                }

                // Mostramos el resultado final
                resultado.setText(nombreDia + " → " + tipoDia);

            } catch (NumberFormatException ex) {
                // Validación: si ingresa letras o símbolos
                resultado.setText("❌ Ingresa solo números válidos");
            }
        });

        // Agregamos todo al marco (igual que tu código original)
        add(etiqueta);
        add(campoNumero);
        add(botonMostrar);
        add(resultado);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Programa4DiasSemana());
    }
}
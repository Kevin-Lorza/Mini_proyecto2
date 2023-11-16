import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CandidatoGUI extends JFrame {
    private JTextField nombreField, cedulaField;
    private JComboBox<String> ciudadComboBox, posicionComboBox, partidoComboBox;

    public CandidatoGUI() {
        super("Registro de Candidato");

        nombreField = new JTextField(20);
        cedulaField = new JTextField(10);

        String[] ciudades = {"Cali", "Buenaventura", "Palmira", "Tulua", "Jamundi", "Cartago", "Zarzal", "Candelaria",
                "Pradera", "Ginebra", "Cerrito", "Roldanillo", "Launion", "Sevilla", "Buga", "Guacari", "Rozo",
                "Caicedonia", "Yumbo", "Florida", "Dagua"};

        ciudadComboBox = new JComboBox<>(ciudades);

        String[] posiciones = {"Derecha", "Izquierda"};
        posicionComboBox = new JComboBox<>(posiciones);

        String[] partidosDerecha = {"Centro Democrático", "Conservador", "Cambio Radical"};
        String[] partidosIzquierda = {"Liberal", "Alianza Verde"};

        partidoComboBox = new JComboBox<>();

        
        setLayout(new GridLayout(5, 2));

        
        add(new JLabel("Nombre:"));
        add(nombreField);

        add(new JLabel("Cédula:"));
        add(cedulaField);

        add(new JLabel("Ciudad de Origen:"));
        add(ciudadComboBox);

        add(new JLabel("Posición:"));
        add(posicionComboBox);

        add(new JLabel("Partido:"));
        add(partidoComboBox);

        
        posicionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPartidos();
            }
        });

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        setSize(400, 200);
        setVisible(true);
    }

    private void actualizarPartidos() {
        partidoComboBox.removeAllItems();
        if (posicionComboBox.getSelectedItem().equals("Derecha")) {
            for (String partido : new String[]{"Centro Democrático", "Conservador", "Cambio Radical"}) {
                partidoComboBox.addItem(partido);
            }
        } else {
            for (String partido : new String[]{"Liberal", "Alianza Verde"}) {
                partidoComboBox.addItem(partido);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CandidatoGUI();
            }
        });
    }
}

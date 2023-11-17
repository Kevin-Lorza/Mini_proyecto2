import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CandidatoGUI extends JFrame {
    private JTextField nombreField, cedulaField, votosField, propuestasField;
    private JComboBox<String> ciudadComboBox, posicionComboBox, partidoComboBox;
    public static ArrayList<Candidato> candidatos;

    public CandidatoGUI(ArrayList<Candidato> candidatos) {
        
        super("Registro de Candidatos");
        this.candidatos = candidatos;

        setTitle("Registro de Candidatos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        nombreField = new JTextField(20);
        cedulaField = new JTextField(10);
        votosField = new JTextField(5);
        propuestasField = new JTextField(20);
        ciudadComboBox = new JComboBox<>(new String[]{"Cali", "Buenaventura", "Palmira", "Tulua", "Jamundi", "Cartago", "Zarzal", "Candelaria", "Pradera", "Ginebra", "Cerrito", "Roldanillo", "Launion", "Sevilla", "Buga", "Guacari", "Rozo", "Caicedonia", "Yumbo", "Florida", "Dagua"});
        posicionComboBox = new JComboBox<>(new String[]{"Derecha", "Izquierda"});
        partidoComboBox = new JComboBox<>();

        posicionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPartidos();
            }
        });

        JButton agregarButton = new JButton("Agregar Candidato");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCandidato();
            }
        });

        setLayout(new GridLayout(8, 2));

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
        add(new JLabel("Cantidad de Votos:"));
        add(votosField);
        add(new JLabel("Propuestas:"));
        add(propuestasField);
        add(agregarButton);

        setVisible(true);
    }

    private void actualizarPartidos() {
        partidoComboBox.removeAllItems();
        if (posicionComboBox.getSelectedItem().equals("Derecha")) {
            partidoComboBox.addItem("Centro Democrático");
            partidoComboBox.addItem("Conservador");
            partidoComboBox.addItem("Cambio Radical");
        } else {
            partidoComboBox.addItem("Liberal");
            partidoComboBox.addItem("Alianza Verde");
        }
    }

    private void agregarCandidato() {
        String nombre = nombreField.getText();
        String cedula = cedulaField.getText();
        String ciudad = (String) ciudadComboBox.getSelectedItem();
        String posicion = (String) posicionComboBox.getSelectedItem();
        String partido = (String) partidoComboBox.getSelectedItem();
        int votos = Integer.parseInt(votosField.getText());
        String propuestas = propuestasField.getText();

        Candidato candidato = new Candidato(nombre, cedula, ciudad, posicion, partido, votos, propuestas);
        candidatos.add(candidato);

        nombreField.setText("");
        cedulaField.setText("");
        votosField.setText("");
        propuestasField.setText("");

        actualizarPartidos();

        JOptionPane.showMessageDialog(this, "Candidato agregado exitosamente");
    }
}

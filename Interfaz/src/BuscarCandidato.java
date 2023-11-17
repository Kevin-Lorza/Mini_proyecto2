import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuscarCandidato extends JFrame {
    private ArrayList<Candidato> candidatos;

    public BuscarCandidato(ArrayList<Candidato> candidatos) {
        super("Buscar Candidato");
        this.candidatos = candidatos;

        setLayout(new BorderLayout());
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelBuscar = new JPanel(new FlowLayout());
        JTextField cedulaField = new JTextField(10);
        JButton buscarButton = new JButton("Buscar");

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCandidatoPorCedula(cedulaField.getText());
            }
        });

        panelBuscar.add(new JLabel("Ingrese la cédula del candidato: "));
        panelBuscar.add(cedulaField);
        panelBuscar.add(buscarButton);

        add(panelBuscar, BorderLayout.CENTER);

        setVisible(true);
    }

    private void buscarCandidatoPorCedula(String cedula) {
        for (Candidato candidato : candidatos) {
            if (candidato.getCedula().equals(cedula)) {
                mostrarDatosCandidato(candidato);
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "No se encontró ningún candidato con esa cédula.");
    }

    private void mostrarDatosCandidato(Candidato candidato) {
        String mensaje = "Nombre: " + candidato.getNombre() +
                "\nCédula: " + candidato.getCedula() +
                "\nCiudad: " + candidato.getCiudad() +
                "\nPosición: " + candidato.getPosicion() +
                "\nPartido: " + candidato.getPartido() +
                "\nVotos: " + candidato.getVotos() +
                "\nPropuestas: " + candidato.getPropuestas();

        JOptionPane.showMessageDialog(this, mensaje, "Datos del Candidato", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void buscarCandidato(ArrayList<Candidato> candidatos) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BuscarCandidato(candidatos);
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EliminarCandidato extends JFrame {
    private JTextField cedulaField;

    public EliminarCandidato(ArrayList<Candidato> candidatos) {
        super("Eliminar Candidato");

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelEliminar = new JPanel(new FlowLayout());
        cedulaField = new JTextField(10);
        JButton eliminarButton = new JButton("Eliminar");

        eliminarButton.addActionListener(e -> eliminarCandidatoPorCedula(candidatos, cedulaField.getText()));

        panelEliminar.add(new JLabel("Ingrese la cédula del candidato a eliminar: "));
        panelEliminar.add(cedulaField);
        panelEliminar.add(eliminarButton);

        add(panelEliminar, BorderLayout.CENTER);

        setVisible(true);
    }

    private void eliminarCandidatoPorCedula(ArrayList<Candidato> candidatos, String cedula) {
        for (Candidato candidato : candidatos) {
            if (candidato.getCedula().equals(cedula)) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar al candidato?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    candidatos.remove(candidato);
                    JOptionPane.showMessageDialog(this, "Candidato eliminado exitosamente");
                    dispose(); 
                    return;
                } else {
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(this, "No se encontró ningún candidato con esa cédula.");
    }

    public static void eliminarCandidato(ArrayList<Candidato> candidatos) {
        SwingUtilities.invokeLater(() -> new EliminarCandidato(candidatos));
    }
}

import javax.swing.*;
import java.awt.*;

public class VerCandidatoGanador extends JFrame {

    public VerCandidatoGanador() {
        super("Candidato Ganador");

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea candidatoGanadorTextArea = new JTextArea();
        candidatoGanadorTextArea.setEditable(false);

        String mensaje;
        if (CandidatoGUI.ganador != null) {
            mensaje = "El candidato ganador es: " + CandidatoGUI.ganador.getNombre() + "\n\n" 
            + "De cedula: " + CandidatoGUI.ganador.getCedula() + "\n\n"
            + "Con : " + CandidatoGUI.ganador.getVotos() + " votos \n\n"
            + "y con las propuestas : " + CandidatoGUI.ganador.getPropuestas() + "\n\n";
        } else {
            mensaje = "No hay candidatos registrados.";
        }

        candidatoGanadorTextArea.setText(mensaje);

        JScrollPane scrollPane = new JScrollPane(candidatoGanadorTextArea);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VerCandidatoGanador();
            }
        });
    }
}

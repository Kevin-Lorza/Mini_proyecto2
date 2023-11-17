import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MostrarCandidatos extends JFrame {

    public MostrarCandidatos(ArrayList<Candidato> candidatos) {
        super("Lista de Candidatos");

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea candidatosTextArea = new JTextArea();
        candidatosTextArea.setEditable(false);

        StringBuilder candidatosText = new StringBuilder();
        for (Candidato candidato : candidatos) {
            candidatosText.append(candidato).append("\n\n");
        }
        candidatosTextArea.setText(candidatosText.toString());

        JScrollPane scrollPane = new JScrollPane(candidatosTextArea);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void mostrarCandidatos(ArrayList<Candidato> candidatos) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MostrarCandidatos(candidatos);
            }
        });
    }
}

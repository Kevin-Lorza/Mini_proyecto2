import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    private ArrayList<Candidato> candidatos = new ArrayList<>();

    public MainGUI() {
        super("Bienvenido al Programa");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuInicio = new JMenu("Inicio");
        menuBar.add(menuInicio);

        JMenuItem menuItemCrearCandidato = new JMenuItem("Crear Candidato");
        menuInicio.add(menuItemCrearCandidato);

        menuItemCrearCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CandidatoGUI candidatoGUI = new CandidatoGUI(candidatos);
                candidatoGUI.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI();
            }
        });
    }
}

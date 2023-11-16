import javax.swing.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame{
    private ArrayList<Candidato> candidatos = new ArrayList<>();

    public MainGUI() {
        super("Bienvenido al Programa");
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuInicio = new JMenu("Inicio");
        menuBar.add(menuInicio);

        JMenuItem menuItemCrearCandidato = new JMenuItem("Crear Candidato");
        JMenuItem menuItemMostrarCandidatos = new JMenuItem("Mostrar Candidatos");
        menuInicio.add(menuItemCrearCandidato);
        menuInicio.add(menuItemMostrarCandidatos);

        menuItemCrearCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CandidatoGUI candidatoGUI = new CandidatoGUI(candidatos);
                candidatoGUI.setVisible(true);
            }
        });

        menuItemMostrarCandidatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarCandidatos.mostrarCandidatos(candidatos);
            }
        });

        this.setContentPane(new imagenFondo());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
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

    public class imagenFondo extends JPanel{
        @Override
        public void paint(Graphics g){
            ImageIcon imagen = new ImageIcon(getClass().getResource("imagen.jpg"));
            g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

}

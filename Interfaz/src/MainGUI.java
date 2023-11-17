import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    public ArrayList<Candidato> candidatos = new ArrayList<>();

    public MainGUI() {
        super("Bienvenido al Programa");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menú Inicio
        JMenu menuInicio = new JMenu("Inicio");
        menuBar.add(menuInicio);

        JMenuItem menuItemCrearCandidato = new JMenuItem("Crear Candidato");
        JMenuItem menuItemMostrarCandidatos = new JMenuItem("Mostrar Candidatos");
        JMenuItem menuItemBuscarCandidato = new JMenuItem("Buscar Candidato");
        JMenuItem menuItemActualizarCandidato = new JMenuItem("Actualizar Candidato");

        menuInicio.add(menuItemCrearCandidato);
        menuInicio.add(menuItemMostrarCandidatos);
        menuInicio.add(menuItemBuscarCandidato);
        menuInicio.add(menuItemActualizarCandidato);

        // Menú Estadísticas
        JMenu menuEstadisticas = new JMenu("Estadísticas");
        menuBar.add(menuEstadisticas);

        JMenuItem menuItemVerGanador = new JMenuItem("Ver Candidato Ganador");
        menuEstadisticas.add(menuItemVerGanador);

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

        menuItemBuscarCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarCandidato.buscarCandidato(candidatos);
            }
        });

        menuItemActualizarCandidato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualizarCandidato ventanaActualizarCandidato = new ActualizarCandidato();
                ventanaActualizarCandidato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventanaActualizarCandidato.setVisible(true);
            }
        });

        menuItemVerGanador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerCandidatoGanador ventanaGanador = new VerCandidatoGanador();
                ventanaGanador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventanaGanador.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(new imagenFondo());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
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

    public class imagenFondo extends JPanel {
        @Override
        public void paint(Graphics g) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("imagen.jpg"));
            g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarCandidato extends JFrame {
    private JTextField cedulaField, nombreField, ciudadField, posicionField, partidoField, propuestasField, votosField;

    public ActualizarCandidato(){
       
        setTitle("Actualizar Candidato");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cedulaField = new JTextField(10);
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCandidato();
            }
        });

        nombreField = new JTextField(10);
        ciudadField = new JTextField(10);
        posicionField = new JTextField(10);
        partidoField = new JTextField(10);
        propuestasField = new JTextField(10);
        votosField = new JTextField(10);

        JButton actualizarButton = new JButton("Actualizar");
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCandidato();
            }
        });

        JPanel panelPrincipal = new JPanel(new GridLayout(10, 2));
        panelPrincipal.add(new JLabel("Cédula:"));
        panelPrincipal.add(cedulaField);
        panelPrincipal.add(new JLabel(""));
        panelPrincipal.add(buscarButton);
        panelPrincipal.add(new JLabel("Nombre:"));
        panelPrincipal.add(nombreField);
        panelPrincipal.add(new JLabel("Ciudad:"));
        panelPrincipal.add(ciudadField);
        panelPrincipal.add(new JLabel("Posición:"));
        panelPrincipal.add(posicionField);
        panelPrincipal.add(new JLabel("Partido:"));
        panelPrincipal.add(partidoField);
        panelPrincipal.add(new JLabel("Propuestas:"));
        panelPrincipal.add(propuestasField);
        panelPrincipal.add(new JLabel("Votos:"));
        panelPrincipal.add(votosField);
        panelPrincipal.add(new JLabel(""));
        panelPrincipal.add(actualizarButton);

        getContentPane().add(panelPrincipal);

        setVisible(true);
    }
    
    private void buscarCandidato() {
        String cedulaBuscada;
        cedulaBuscada = cedulaField.getText();
        CandidatoGUI.candidatos.forEach( i ->{
            if (i.getCedula().equals(cedulaBuscada)) {
                nombreField.setText(i.getNombre());
                ciudadField.setText(i.getCiudad());
                posicionField.setText(i.getPosicion());
                partidoField.setText(i.getPartido());
                propuestasField.setText(i.getPropuestas());
                votosField.setText(String.valueOf(i.getVotos()));
                return;  
            }
        });

        JOptionPane.showMessageDialog(this, "Candidato no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void actualizarCandidato() {
        String cedulaBuscada = cedulaField.getText();
        CandidatoGUI.candidatos.forEach(i ->{
            if (i.getCedula().equals(cedulaBuscada)) {
      
                i.setNombre(nombreField.getText());
                i.setCiudad(ciudadField.getText());
                i.setPosicion(posicionField.getText()); 
                i.setPartido(partidoField.getText());
                i.setPropuestas(propuestasField.getText());
                try {
                    i.setVotos(Integer.parseInt(votosField.getText()));
                } catch (NumberFormatException e) {
                    
                    JOptionPane.showMessageDialog(this, "Ingrese un valor válido para votos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }    

            });
    }
    
    
    public static void main(String[] args) {
 
        new ActualizarCandidato();
    }
}

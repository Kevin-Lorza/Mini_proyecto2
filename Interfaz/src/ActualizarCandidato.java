import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarCandidato extends JFrame {
    private JTextField cedulaField, nombreField, propuestasField, votosField;
    private JComboBox<String> ciudadComboBox, posicionComboBox, partidoComboBox;
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
        ciudadComboBox = new JComboBox<>(new String[]{"Cali", "Buenaventura", "Palmira", "Tulua", "Jamundi", "Cartago", "Zarzal", "Candelaria", "Pradera", "Ginebra", "Cerrito", "Roldanillo", "Launion", "Sevilla", "Buga", "Guacari", "Rozo", "Caicedonia", "Yumbo", "Florida", "Dagua"});
        posicionComboBox = new JComboBox<>(new String[]{"Derecha", "Izquierda"});
        propuestasField = new JTextField(10);
        votosField = new JTextField(10);
        partidoComboBox = new JComboBox<>();

        posicionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPartidos();
            }
        });


        JButton actualizarButton = new JButton("Actualizar");
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCandidato();
            }
        });

        JPanel panelPrincipal = new JPanel(new GridLayout(9, 2));
        panelPrincipal.add(new JLabel("Cédula:"));
        panelPrincipal.add(cedulaField);
        panelPrincipal.add(new JLabel(""));
        panelPrincipal.add(buscarButton);
        panelPrincipal.add(new JLabel("Nombre:"));
        panelPrincipal.add(nombreField);
        panelPrincipal.add(new JLabel("Ciudad:"));
        panelPrincipal.add(ciudadComboBox);
        panelPrincipal.add(new JLabel("Posición:"));
        panelPrincipal.add(posicionComboBox);
        panelPrincipal.add(new JLabel("Partido:"));
        panelPrincipal.add(partidoComboBox);
        panelPrincipal.add(new JLabel("Propuestas:"));
        panelPrincipal.add(propuestasField);
        panelPrincipal.add(new JLabel("Votos:"));
        panelPrincipal.add(votosField);
        panelPrincipal.add(new JLabel(""));
        panelPrincipal.add(actualizarButton);

        getContentPane().add(panelPrincipal);

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

    private void buscarCandidato() {
        String cedulaBuscada;
        cedulaBuscada = cedulaField.getText();
        CandidatoGUI.candidatos.forEach( i ->{
            if (i.getCedula().equals(cedulaBuscada)) {
                nombreField.setText(i.getNombre());
                ciudadComboBox.getSelectedItem();
                posicionComboBox.getSelectedItem();
                partidoComboBox.getSelectedItem();
                propuestasField.setText(i.getPropuestas());
                votosField.setText(String.valueOf(i.getVotos()));
                return;  
            }
        });

    }

    public void actualizarCandidato() {
        String cedulaBuscada = cedulaField.getText();
        CandidatoGUI.candidatos.forEach(i ->{
            if (i.getCedula().equals(cedulaBuscada)) {
      
                i.setNombre(nombreField.getText());
                i.setCiudad((String)ciudadComboBox.getSelectedItem());
                i.setPosicion((String)posicionComboBox.getSelectedItem()); 
                i.setPartido((String)partidoComboBox.getSelectedItem());
                i.setPropuestas(propuestasField.getText());
                try {
                    i.setVotos(Integer.parseInt(votosField.getText()));
                } catch (NumberFormatException e) {
                    
                    JOptionPane.showMessageDialog(this, "Ingrese un valor válido para votos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Candidato actualizado correctamente", "Error", JOptionPane.INFORMATION_MESSAGE);
            }    

            });
    }
    
    
    public static void main(String[] args) {
 
        new ActualizarCandidato();
    }
}

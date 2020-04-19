package prPractica15;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI08Eventos extends JFrame {
	
	private static final long serialVersionUID = 1037775860064640334L;
	
	private JCheckBox diesel;
	private JCheckBox asientos;
	private JCheckBox tapiceria;
	private JCheckBox llantas;
	private JCheckBox pintura;
	private JComboBox<String> radios;
	private JList<String> colores;
	private JScrollPane spColores;
	private JLabel etiqueta;
	
	public GUI08Eventos() {
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setPreferredSize(new Dimension(300, 350));
		panelPrincipal.setBorder(new EmptyBorder(15,15,15,15));
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		Container contentPane = this.getContentPane();
		contentPane.add(panelPrincipal);
		
		//panel extras
		JPanel panelExtras = new JPanel();
		panelExtras.setLayout(new GridLayout(5, 1));
		panelExtras.setBorder(new TitledBorder("Elija extras"));
		
		diesel = new JCheckBox("Diesel", true);
		asientos = new JCheckBox("Asientos deportivos", true);
		tapiceria = new JCheckBox("Tapicería", true);
		llantas = new JCheckBox("Llantas de aleación");
		pintura = new JCheckBox("Pintura metalizada", true);
		
		tapiceria.setEnabled(false);
		
		panelExtras.add(diesel);
		panelExtras.add(asientos);
		panelExtras.add(tapiceria);
		panelExtras.add(llantas);
		panelExtras.add(pintura);
		
		//panel llantas
		JPanel panelLlantas = new JPanel();
		panelLlantas.setBorder(new TitledBorder("Elija número de llantas"));
		
		String [] arrayCombo = {"Tres radios", "Cinco radios", "Siete radios", "Nueve radios"};
		radios = new JComboBox<String>(arrayCombo);
		radios.setEnabled(false);
		
		panelLlantas.add(radios);
		
		//panel color
		JPanel panelColor = new JPanel();
		panelColor.setPreferredSize(new Dimension(80, 80));
		panelColor.setBorder(new TitledBorder("Elija color"));
		
		String [] arrayLista = {"Rojo", "Verde", "Azul", "Amarillo", "Negro", "Gris"};
		colores = new JList<String>(arrayLista);
		
		spColores = new JScrollPane(colores);
		spColores.setPreferredSize(new Dimension(80, 40));
		
		panelColor.add(spColores);
		
		//panel etiqueta
		JPanel panelEtiqueta = new JPanel();
		panelEtiqueta.setBorder(new TitledBorder("Acciones realizadas"));
		
		etiqueta = new JLabel("Información", JLabel.CENTER);
		etiqueta.setForeground(Color.blue);
		
		panelEtiqueta.add(etiqueta);
		
		panelPrincipal.add(panelExtras);
		panelPrincipal.add(panelLlantas);
		panelPrincipal.add(panelColor);
		panelPrincipal.add(panelEtiqueta);
		
		colores.addListSelectionListener(new ControlLista());
		diesel.addItemListener(new ControlItems());
		llantas.addItemListener(new ControlItems());
		tapiceria.addItemListener(new ControlItems());
		asientos.addItemListener(new ControlItems());
		pintura.addItemListener(new ControlItems());
		radios.addItemListener(new ControlItems());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI08Eventos ventana = new GUI08Eventos();

		ventana.pack();
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	class ControlLista implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			
			etiqueta.setText("Color pintura: " + colores.getSelectedValue());
			
		}
		
	}
	
	class ControlItems implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource()==radios) {
				etiqueta.setText("Numero de radios: " + radios.getSelectedItem());
			}
			
			int estadoCheck = e.getStateChange();
			String textoCheck = ((JCheckBox)e.getSource()).getText();
			
			etiqueta.setText("Check pulsado: " + textoCheck);
			
			if (textoCheck.equals(llantas.getText()))
				radios.setEnabled(estadoCheck==ItemEvent.SELECTED);
			else if (textoCheck.equals(pintura.getText())) {
				spColores.setVisible(estadoCheck==ItemEvent.SELECTED);
			}
			
			else if (textoCheck.equals(asientos.getText())) {
				tapiceria.setSelected(estadoCheck==ItemEvent.SELECTED);
				tapiceria.setEnabled(estadoCheck==ItemEvent.DESELECTED);
				etiqueta.setText("Check pulsado: Asientos deportivos");
			}
			
		}
		
	}

}

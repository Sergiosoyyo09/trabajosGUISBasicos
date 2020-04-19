package prPractica15;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI05Eventos extends JFrame {
	
	private static final long serialVersionUID = 1462243413787784878L;
	
	private JCheckBox melon;
	private JCheckBox naranja;
	private JCheckBox platano;
	private JCheckBox manzana;
	private JTextArea area;
	
	public GUI05Eventos() {
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		
		contentPane.add(panelPrincipal);
		
		//Zona iz
		JPanel izquierda = new JPanel();
		izquierda.setLayout(new GridLayout(4, 1));
		
		//componentes
		melon = new JCheckBox("Melón");
		naranja = new JCheckBox("Naranja");
		platano = new JCheckBox("Plátano");
		manzana = new JCheckBox("Manzana");
		
		izquierda.add(melon);
		izquierda.add(naranja);
		izquierda.add(platano);
		izquierda.add(manzana);
		
		//Zona de
		JPanel derecha = new JPanel();
		derecha.setLayout(new FlowLayout());
		
		//componentes
		area = new JTextArea(10, 16);
		area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area);
		scroll.setPreferredSize(new Dimension(150, 150));
		
		
		derecha.add(scroll);
		
		panelPrincipal.add(izquierda, BorderLayout.WEST);
		panelPrincipal.add(derecha, BorderLayout.EAST);
		
		melon.addItemListener(new ControlItems());
		naranja.addItemListener(new ControlItems());
		platano.addItemListener(new ControlItems());
		manzana.addItemListener(new ControlItems());
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI05Eventos ventana = new GUI05Eventos();

		ventana.pack();
		ventana.setVisible(true);
		ventana.setSize(300, 200);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	class ControlItems implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			JCheckBox checkPulsado = (JCheckBox) e.getSource();
			
			area.append("Componente: " + checkPulsado.getText() + "\n");
			area.append("Componente: " + checkPulsado.isSelected() + "\n");
			area.append("Componente: " + e.getStateChange() + "\n");
			
			if (checkPulsado.isSelected())
				area.append("Seleccionado\n");
			else area.append("No Seleccionado\n");
			
			/*if (e.getStateChange()==1)
				area.append("Seleccionado\n");
			else area.append("No Seleccionado\n");
			
			if (e.getStateChange()==ItemEvent.SELECTED)
				area.append("Seleccionado\n");
			else area.append("No Seleccionado\n");
			
			area.append(checkPulsado.isSelected()
					?"Seleccionado\n":"No seleccionado\n");
			area.append(e.getStateChange()==ItemEvent.SELECTED
					?"Seleccionado\n":"No seleccionado\n");*/
			
			area.append("\n");
			
			}
			
		}

}

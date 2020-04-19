package prPractica15;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class GUI02Eventos extends JFrame {

	private static final long serialVersionUID = 1130010545907935990L;

	private JTextArea campoTexto;
	private JTextField texto;
	private JLabel etiqueta;
	private JComboBox<String> miCombo;
	private JButton boton;
	private JList<String> miLista;

	public GUI02Eventos() {

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		//componentes zona norte
		texto = new JTextField("Campo de texto");
		etiqueta = new JLabel("Una etiqueta");
		miCombo = new JComboBox<String>();
		for (int i=1; i<=15; i++)
			miCombo.addItem("Selecciona Item #"+i);
		boton = new JButton("Botón");

		//panel norte
		JPanel jpno = new JPanel();
		jpno.setLayout(new FlowLayout());
		jpno.add(texto);
		jpno.add(etiqueta);
		jpno.add(miCombo);
		jpno.add(boton);

		//componentes zona cento
		String [] arrayLista = new String[15];
		for (int i=0; i<arrayLista.length; i++)
			arrayLista[i] = "Lista Item #"+(i+1);
		miLista = new JList<String>(arrayLista);

		JScrollPane scrollLista = new JScrollPane(miLista);

		JPanel jpce = new JPanel();
		jpce.setLayout(new GridLayout(2,1));
		jpce.add(scrollLista);

		//componentes sur
		campoTexto = new JTextArea();
		JScrollPane scrollArea = new JScrollPane(campoTexto);

		JPanel jpsu = new JPanel();
		jpsu.setLayout(new GridLayout());
		jpsu.add(scrollArea);

		jpce.add(scrollArea);
		
		contentPane.add(jpno, BorderLayout.NORTH);
		contentPane.add(jpce, BorderLayout.CENTER);
		
		ControlFoco cf = new ControlFoco();
		texto.addFocusListener(cf);
		etiqueta.addFocusListener(cf);
		miCombo.addFocusListener(cf);
		boton.addFocusListener(cf);
		miLista.addFocusListener(cf);

	}
	
	class ControlFoco implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource()==e.getComponent()) {
				campoTexto.append("Foco ganado: " + e.getComponent() + "\n");
			}
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource()==e.getComponent()) {
				campoTexto.append("Foco perdido: " + e.getComponent() + "\n");
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GUI02Eventos ventana = new GUI02Eventos();

		ventana.pack();
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

package prPractica15;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class GUI03Eventos extends JFrame {
	
	private static final long serialVersionUID = 5696889109968982178L;

	private JButton boton;
	private JLabel etiqueta;
	
	public GUI03Eventos() {
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout(15,15));
		
		boton = new JButton("Bienvenido");
		etiqueta = new JLabel("Aqui aparecera una descripcion de los eventos");
		
		JPanel centro = new JPanel();
		centro.add(boton);
		boton.setPreferredSize(new Dimension(100, 100));
		
		JPanel sur = new JPanel();
		sur.add(etiqueta);
		
		contentPane.add(centro, BorderLayout.CENTER);
		contentPane.add(sur, BorderLayout.SOUTH);
		
		boton.addMouseListener(new ControlRaton());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI03Eventos ventana = new GUI03Eventos();

		ventana.pack();
		ventana.setVisible(true);
		ventana.setSize(400, 200);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	class ControlRaton implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			//etiqueta.setText("Botón pulsado y soltado.");
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
			etiqueta.setText("Botón pulsado en posicion: " + e.getX() + ", " + e.getY());
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
			etiqueta.setText("Botón soltado en posicion: " + e.getX() + ", " + e.getY());
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
			e.getComponent().setBackground(Color.decode("#00B347"));
			etiqueta.setText("Entro en el botón con el ratón. ");
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
			e.getComponent().setBackground(Color.decode("#00722E"));
			etiqueta.setText("Salgo del botón con el ratón. ");
			
		}
		
		
	}

}

package prPractica15;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GUI06Eventos extends JFrame {

	private static final long serialVersionUID = -8732195977230972779L;
	
	private JButton boton1;
	private JButton boton2;
	private JTextField campo;
	
	public GUI06Eventos() {
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(3, 1));		
		
		boton1 = new JButton("Primero");
		boton2 = new JButton("Segundo");
		campo = new JTextField();
		
		contentPane.add(boton1);
		contentPane.add(boton2);
		contentPane.add(campo);
		
		boton2.addKeyListener(new ControlTeclado());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI06Eventos ventana = new GUI06Eventos();

		ventana.pack();
		ventana.setVisible(true);
		ventana.setSize(200, 100);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	class ControlTeclado implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub			
			if (e.getKeyChar()!='*') {
				campo.setText(campo.getText() + e.getKeyChar());
			}
			else System.exit(0);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}

}

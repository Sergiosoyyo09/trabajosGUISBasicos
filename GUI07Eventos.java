package prPractica15;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI07Eventos extends JFrame {

	private static final long serialVersionUID = 3733811702213056027L;
	
	private JTextArea area;
	
	public GUI07Eventos() {
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		area = new JTextArea(50, 0);
		area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area);
		
		contentPane.add(scroll);
		
		area.addKeyListener(new ControlTeclado());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI07Eventos ventana = new GUI07Eventos();

		ventana.pack();
		ventana.setVisible(true);
		ventana.setSize(300, 300);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	class ControlTeclado implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
			area.append("Tecla pulsada y soltada -->" + e.getKeyChar() + "\n");
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			area.append("Tecla pulsada" + "\n");
			
			if (e.getKeyChar()=='h' || e.getKeyChar()=='H') {
				area.append("HOLA!" + "\n");
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
			area.append("Tecla soltada" + "\n");
			
		}
		
		
		
	}

}

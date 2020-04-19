package prPractica15;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI04Eventos extends JFrame {
	
	JLabel etiqueta1;
	JLabel etiqueta2;

	private static final long serialVersionUID = -2204754553896680755L;
	
	public GUI04Eventos() {
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		etiqueta1 = new JLabel("000");
		etiqueta2 = new JLabel("000");
		
		contentPane.add(etiqueta1);
		contentPane.add(etiqueta2);
		
		contentPane.addMouseMotionListener(new ControlRaton());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI04Eventos ventana = new GUI04Eventos();

		ventana.pack();
		ventana.setVisible(true);
		ventana.setSize(400, 200);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	class ControlRaton implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
			etiqueta1.setForeground(Color.blue);
			etiqueta2.setForeground(Color.blue);
			
			etiqueta1.setText(String.valueOf(e.getX()));
			etiqueta2.setText(String.valueOf(e.getY()));
			
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
			etiqueta1.setForeground(Color.red);
			etiqueta2.setForeground(Color.red);
			
			etiqueta1.setText(String.valueOf(e.getX()));
			etiqueta2.setText(String.valueOf(e.getY()));
			
		}
		
	}

}

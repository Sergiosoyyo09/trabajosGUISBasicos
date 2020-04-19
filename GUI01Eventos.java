package prPractica15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI01Eventos extends JFrame {
	
	private static final long serialVersionUID = -8308811391227362787L;
	
	private JLabel etiqueta;
	private JTextField campoContrase�a;
	private JTextField campoUsuario;
	private JButton aceptar;
	private JButton cancelar;
	
	public GUI01Eventos() {
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		panelPrincipal.setBorder(new EmptyBorder(10,0,10,0));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 3));
		
		//Componentes
		JLabel usuario = new JLabel("Usuario: ", JLabel.RIGHT);
		JLabel contrasena = new JLabel("Contrase�a: ", JLabel.RIGHT);
		campoUsuario = new JTextField();
		campoContrase�a = new JTextField();
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		
		etiqueta = new JLabel("Introduzca usuario y clave");
		
		panel.add(usuario);
		panel.add(campoUsuario);
		panel.add(aceptar);
		panel.add(contrasena);
		panel.add(campoContrase�a);
		panel.add(cancelar);
		
		panelPrincipal.add(panel, BorderLayout.CENTER);
		panelPrincipal.add(etiqueta, BorderLayout.SOUTH);
		
		contentPane.add(panelPrincipal);
		
		ControlBoton cb = new ControlBoton();
		aceptar.addActionListener(cb);
		cancelar.addActionListener(cb);
		
	}
	
	class ControlBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource()==aceptar && campoUsuario.getText().equalsIgnoreCase("mipierna") && campoContrase�a.getText().equalsIgnoreCase("entutumba")) {
				etiqueta.setText("Datos correctos");
			}
			
			else {
				etiqueta.setText("Datos incorrectos");
			}
			
			if (e.getSource()==cancelar) {
				campoUsuario.setText("");
				campoContrase�a.setText("");
				etiqueta.setText("Introduzca usuario y clave");
			}
			
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI01Eventos ventana = new GUI01Eventos();
		
		ventana.pack();
		ventana.setSize(400, 150);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

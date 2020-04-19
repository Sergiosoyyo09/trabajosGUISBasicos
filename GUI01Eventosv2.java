package prPractica15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI01Eventosv2 extends JFrame {
	
	private static final long serialVersionUID = -8308811391227362787L;
	
	private JLabel etiqueta;
	private JPasswordField campoContraseña;
	private JTextField campoUsuario;
	private JButton aceptar;
	private JButton cancelar;
	
	public GUI01Eventosv2() {
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(50, 30));
		panelPrincipal.setBorder(new EmptyBorder(10,0,10,0));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 3));
		
		//Componentes
		JLabel usuario = new JLabel("Usuario: ", JLabel.RIGHT);
		JLabel contrasena = new JLabel("Contraseña: ", JLabel.RIGHT);
		campoUsuario = new JTextField();
		campoContraseña = new JPasswordField();
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		
		etiqueta = new JLabel("Introduzca usuario y clave");
		
		panel.add(usuario);
		panel.add(campoUsuario);
		panel.add(aceptar);
		panel.add(contrasena);
		panel.add(campoContraseña);
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
			
			if (e.getSource()==aceptar && campoUsuario.getText().equalsIgnoreCase("Sergio") && campoContraseña.getText().equalsIgnoreCase("entutumba")) {
				etiqueta.setText("Datos correctos");
			}
			
			else {
				etiqueta.setText("Datos incorrectos");
			}
			
			if (e.getSource()==cancelar) {
				campoUsuario.setText("");
				campoContraseña.setText("");
				etiqueta.setText("Introduzca usuario y clave");
			}
			
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI01Eventosv2 ventana = new GUI01Eventosv2();
		
		ventana.pack();
		ventana.setSize(400, 150);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

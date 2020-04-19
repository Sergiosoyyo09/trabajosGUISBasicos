package prPractica15;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GUI10Eventos extends JFrame {

	private static final long serialVersionUID = 922917773054556184L;

	private JTextField campo;
	private JButton boton1;
	
	private JTextField campo2;
	private JButton boton2;
	
	private JComboBox<String> comboDia;
	private JComboBox<String> comboMes;
	private JComboBox<String> comboAnnio;
	private JButton boton3;
	
	private JLabel etiqueta;

	public GUI10Eventos() {

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(4, 1));

		//panel
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
		panel1.setBorder(new TitledBorder("Validar forma 1 - dd/mm/aaaa"));


		//componentes
		campo = new JTextField(10);
		boton1 = new JButton("Validar");

		panel1.add(campo);
		panel1.add(boton1);

		etiqueta = new JLabel("Informacion sobre la validacion.", JLabel.CENTER);

		contentPane.add(panel1);
		contentPane.add(etiqueta);

		//panel
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBorder(new EmptyBorder(15, 15, 15, 15));
		panel2.setBorder(new TitledBorder("Validar forma 2 - dd-mm-aaaa"));


		//componentes
		campo2 = new JTextField(10);
		boton2 = new JButton("Validar");

		panel2.add(campo2);
		panel2.add(boton2);
		
		//panel
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setBorder(new EmptyBorder(15, 15, 15, 15));
		panel3.setBorder(new TitledBorder("Validar forma 3 - JComboBox"));
		
		comboDia = new JComboBox<String>();
		for (int i=1; i<=31; i++)
			comboDia.addItem(""+i);
		
		comboMes = new JComboBox<String>();
		for (int i=1; i<=12; i++)
			comboMes.addItem(""+i);
		
		comboAnnio = new JComboBox<String>();
		for (int i=2000; i<=2100; i++)
			comboAnnio.addItem(""+i);
		
		boton3 = new JButton("Validar");
		
		panel3.add(comboDia);
		panel3.add(comboMes);
		panel3.add(comboAnnio);
		panel3.add(boton3);

		contentPane.add(panel1);
		contentPane.add(panel2);
		contentPane.add(panel3);
		contentPane.add(etiqueta);

		ControlEventos ce = new ControlEventos();
		boton1.addActionListener(ce);
		boton2.addActionListener(ce);
		boton3.addActionListener(ce);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GUI10Eventos ventana = new GUI10Eventos();

		ventana.pack();
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class ControlEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String cad = comboDia.getSelectedItem().toString() + "/" + comboMes.getSelectedItem().toString() + "/" + comboAnnio.getSelectedItem().toString();

			if (e.getSource()==boton1 && LibreriaFechas.validarFecha(campo.getText()) || 
					e.getSource()==boton2 && LibreriaFechas.validarFecha2(campo2.getText()) ||
					e.getSource()==boton3 && LibreriaFechas.validarFecha(cad)) {
				etiqueta.setText("Validacion correcta");
				etiqueta.setForeground(Color.blue);
			}
			else {
				etiqueta.setText("Fecha incorrecta");
				etiqueta.setForeground(Color.red);
			}

		}

	}

}

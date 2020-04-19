package prPractica15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

public class Dados extends JFrame {

	private static final long serialVersionUID = -1260995622598335775L;

	private JButton bLanzarDados;
	private JTextField dado1;
	private JTextField dado2;
	private JTextField resultado1;
	private JTextField resultado2;
	private JLabel etiquetaPuntos;
	private int puntos;

	public Dados() {
		super("JuegoDados");
		setIconImage(new ImageIcon("dados.gif").getImage());

		Container contentPane = this.getContentPane();

		JPanel panelPuntos = new JPanel();
		panelPuntos.setLayout(new FlowLayout(FlowLayout.RIGHT));

		Font fuente = new Font("Comic Sans MS", Font.BOLD, 15);

		etiquetaPuntos = new JLabel("0");
		JLabel etiquetaAuxiliar = new JLabel("Puntos obtenidos: ");

		etiquetaPuntos.setFont(fuente);
		etiquetaAuxiliar.setFont(fuente);

		panelPuntos.add(etiquetaAuxiliar);
		panelPuntos.add(etiquetaPuntos);

		JPanel panelUsuario = new JPanel(new GridLayout(2, 1));
		panelUsuario.setBorder(new CompoundBorder(
				new TitledBorder("Apuesta Jugador"),
				new BevelBorder(BevelBorder.RAISED)));

		dado1 = new JTextField(2);
		dado2 = new JTextField(2);

		dado1.setFont(fuente);
		dado2.setFont(fuente);

		dado1.setBorder(new TitledBorder("Dado 1"));
		dado2.setBorder(new TitledBorder("Dado 2"));

		panelUsuario.add(dado1);
		panelUsuario.add(dado2);

		JPanel panelResultado = new JPanel(new GridLayout(2,1));

		panelResultado.setBorder(new CompoundBorder(
				new TitledBorder("Resultado"),
				new BevelBorder(BevelBorder.RAISED)));

		resultado1 = new JTextField(2);
		resultado2 = new JTextField(2);

		resultado1.setBorder(new TitledBorder("Dado 1"));
		resultado2.setBorder(new TitledBorder("Dado 2"));

		panelResultado.add(resultado1);
		panelResultado.add(resultado2);

		resultado1.setEditable(false);
		resultado2.setEditable(false);
		resultado1.setBackground(Color.white);
		resultado2.setBackground(Color.white);

		resultado1.setFont(fuente);
		resultado2.setFont(fuente);

		JPanel panelCentral = new JPanel(new GridLayout(1,2));
		panelCentral.add(panelUsuario);
		panelCentral.add(panelResultado);

		JPanel panelBoton = new JPanel();
		bLanzarDados = new JButton("Lanzar dados",
				new ImageIcon("dados-03.gif"));
		bLanzarDados.setBorder(new BevelBorder(BevelBorder.RAISED));
		panelBoton.add(bLanzarDados);

		contentPane.add(panelPuntos, BorderLayout.NORTH);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		contentPane.add(panelBoton, BorderLayout.SOUTH);

		bLanzarDados.addActionListener(new ControlBoton(this));


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dados d = new Dados();

		d.pack();
		d.setSize(400,250);
		d.setResizable(false);
		d.setVisible(true);
		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class ControlBoton implements ActionListener {

		JFrame frame;

		public ControlBoton(JFrame f) {
			this.frame = f;
		}

		public void actionPerformed(ActionEvent e) {
			Integer dadoAleatorio1, dadoAleatorio2, dadoUsu1, dadoUsu2;
			try {

				dadoAleatorio1=(int)(Math.random()*6)+1;
				dadoAleatorio2=(int)(Math.random()*6)+1;

				resultado1.setText(dadoAleatorio1.toString());
				resultado2.setText(dadoAleatorio2.toString());

				dadoUsu1=Integer.parseInt(dado1.getText());
				dadoUsu2=Integer.parseInt(dado2.getText());

				if ((dadoUsu1<1) || (dadoUsu1>6) || (dadoUsu2<1) || (dadoUsu2>6)) {
					throw new NumberFormatException();
				}
				else if (((dadoAleatorio1==dadoUsu1) && (dadoAleatorio2==dadoUsu2)) ||
						((dadoAleatorio1==dadoUsu2) && (dadoAleatorio2==dadoUsu1))) {
					puntos=puntos+25;
				}
				else if ((dadoAleatorio1==dadoUsu1) || (dadoAleatorio2==dadoUsu2) ||
						(dadoAleatorio1==dadoUsu2) || (dadoAleatorio2==dadoUsu1)) {
					puntos=puntos+10;
				}
				else puntos=puntos-5;

				etiquetaPuntos.setText(String.valueOf(puntos));
			}
			catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this.frame,"Debe introducir dos número entre 1 y 6");
			}

		}

	}

}

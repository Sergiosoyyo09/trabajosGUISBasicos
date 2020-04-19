package prPractica15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.*;

@SuppressWarnings("serial")
public class GUI09Eventos extends JFrame
{
	// Variables de instancia
    private JButton euro, peseta, desglose;
    private JTextField tf;
    private JTextArea ta;
  
    
   // Constructor
   public GUI09Eventos()
    {
	   
       	Container contentPane = getContentPane();
       
       	JPanel p1=new JPanel();
       	p1.add(new JLabel("Visor de resultado",JLabel.RIGHT));
       	tf=new JTextField(15);
       	tf.setAlignmentX(RIGHT_ALIGNMENT);
       	p1.add(tf);

       
       	euro=new JButton("A euros");
       	peseta=new JButton("A pesetas");
       	desglose=new JButton("Desglose");
       	JPanel p2=new JPanel();
       	p2.add(euro);
       	p2.add(peseta);
       	p2.add(desglose);

       	ta=new JTextArea(10,20);
       	JScrollPane sp = new JScrollPane(ta);
       	contentPane.add("North",p1);
    	contentPane.add("Center",p2);
    	contentPane.add("South",sp);

       	
       	ControlEventos ce = new ControlEventos(this);
       	euro.addActionListener(ce);
       	peseta.addActionListener(ce);
       	desglose.addActionListener(ce);
       	
       	euro.addFocusListener(ce);
       	peseta.addFocusListener(ce);
       	
	
       	// Añado el control al cierre de la ventana
       	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
       	setResizable(false);
       	pack();
       	setVisible(true);
	
    }
	
    public static void main(String[] args) 
    {
    	new GUI09Eventos();

   }

    class ControlEventos implements ActionListener, FocusListener
    {
    
    	private JFrame f;
    	
    	/**
    	 *  Constructor
    	 * @param f
    	 */
    	
    	public ControlEventos(JFrame f)
    	{
    		this.f = f;
    	}
    
    	
    	/**
    	 * CONTROL DEL EVENTOS ACTION EVENT
    	 */

    	
    	public void actionPerformed(ActionEvent e)
    	{
      		Double valor;
    		JButton bp;  // Boton pulsado
    		
    		bp = (JButton) e.getSource();
    		
    	    try // Control de excepciones
    	    {
    	        		 
    	      if (bp==peseta) {  // Conversion a pesetas
    			  DecimalFormat patron = new DecimalFormat("#");
    			  valor = (new Double(tf.getText())) * 166.386 ;
     			  tf.setText(patron.format(valor).toString());
    		  }
    		  else if (bp==euro) { // Conversion a euros
    			  DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    			  simbolos.setDecimalSeparator('.');
    				
    			  DecimalFormat patron = new DecimalFormat("0.00",simbolos);
    			  
    			  valor = (new Double(tf.getText())) / 166.386;
       			  tf.setText(patron.format(valor).toString());
       		  }
    		  else { // Desglose en euros
    				desglosar();
    		  }
    		}// Fin try
    	  	catch (NumberFormatException e1) {
    	  	  		JOptionPane.showMessageDialog(f, "Debe introducir un número.");
    	  	}
    	}

    	/**
    	 * Método que desglosa en billetes y monedas una cantidad en euros
    	 */
    	private void desglosar()
    	{
       		double [] array = {500,200,100,50,20,10,5,2,1,0.50,0.20,0.10,0.05,0.02,0.01};
       		double num, resto;
    		int aux;
       		ta.setText("");
  
       		num = Double.parseDouble(tf.getText());
    		for (int i=0; i<15; i++)
    		{
      			aux=(int)(num/array[i]);;
    			resto=(num%array[i]);
    			
    				if (array[i]>=5) {  // Billetes
    					num=resto;
    					if (aux!=0)
    						ta.append(aux+" billetes de "+(int) array[i]+" euros\n");
    				}
    				else  
    					if (array[i]>=1) { // Monedas de 1 o 2 euros
    						num=resto;
    						if (aux!=0)
    							ta.append(aux+" monedas de "+(int) array[i]+" euros\n");
    					}
    					else { // Resto de monedas
       						num = this.redondea(resto,2);  // Redondeo a 2 decimales
       						if (aux!=0)
       							ta.append(aux+" monedas de "+(int)(array[i]*100)+" céntimos\n");
    					}
    		}
    	}
    
    
       	
    	private double redondea(double num, int numDecimales)
    	{
    		
    		double aux1=Math.round(num*Math.pow(10,numDecimales));
			double aux2=aux1/Math.pow(10,numDecimales);
			return aux2;
    	}
    
    	
       	/**
    	 * CONTROL DEL EVENTO FOCUS EVENT
    	 */	

    	/**
    	 * Redefinición del método focusGained de la interfaz FocusListener
    	 */
		public void focusGained(FocusEvent arg0) {
			arg0.getComponent().setBackground(Color.CYAN);
		}

    	/**
    	 * Redefinición del método focusLost de la interfaz FocusListener
    	 */
		public void focusLost(FocusEvent arg0) {
			arg0.getComponent().setBackground(UIManager.getColor("Button.background"));
		}
    
    }
}






















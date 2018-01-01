import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Classe que utilitza classes internes (i concreta per a realitzar un
 * callback). Presenta la hora en un quadre de diˆleg
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 * 
 */
public class ClasseInterna {
	public static void main(String[] agrs) {
		RellotgeInterna rellotge = new RellotgeInterna(1000);
		rellotge.inici();		
	}
}

/**
 * Classe Rellotge
 * 
 * @author sergi
 * 
 */
class RellotgeInterna {
	private int interval;
	private Date data; //accessible des de la classe interna
	public RellotgeInterna(int interval) {
		this.interval = interval;

	}

	public void inici() {
		ActionListener esdeveniment = new Esdeveniment();
		Timer t = new Timer(interval, esdeveniment);
		t.start();
		JOptionPane.showMessageDialog(null, "Voleu acabar el rellotge?");
		System.exit(0);
	}

	/**
	 * Classe Interna (callback) que implementa ActionListener
	 * 
	 * @author sergi grau
	 * @version 1.0, 18.01.2010
	 * 
	 */
	public class Esdeveniment implements ActionListener {
		public void actionPerformed(ActionEvent event) {	
			data = new Date(); //atribut de la classe externa
			System.out.println(data);
		}
	}
}

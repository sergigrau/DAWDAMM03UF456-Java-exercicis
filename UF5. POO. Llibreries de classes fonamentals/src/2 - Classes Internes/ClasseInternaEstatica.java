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
public class ClasseInternaEstatica {
	public static void main(String[] agrs) {
		RellotgeInternaEstatica rellotge = new RellotgeInternaEstatica(1000);
		rellotge.inici();		
	}
}

/**
 * Classe Rellotge. La classe interna es crea estˆtica i no pot accedir a la classe externa.
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 * 
 */
class RellotgeInternaEstatica {
	private int interval;
	
	public RellotgeInternaEstatica(int interval) {
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
	 * Classe Interna Estˆtica (callback) que implementa ActionListener
	 * 
	 * @author sergi grau
	 * @version 1.0, 18.01.2010
	 * 
	 */
	public static class Esdeveniment implements ActionListener {
		public void actionPerformed(ActionEvent event) {	
			Date data = new Date(); //no podem accedir a l'atribut de la classe externa
			System.out.println(data);
		}
	}
	
}

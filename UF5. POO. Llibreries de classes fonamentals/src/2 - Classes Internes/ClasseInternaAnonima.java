import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Classe que utilitza classes internes (i concreta per a realitzar un
 * callback). Presenta la hora en un quadre de diàleg
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 * 
 */
public class ClasseInternaAnonima {
	public static void main(String[] agrs) {
		RellotgeInternaAnonima rellotge = new RellotgeInternaAnonima(1000);
		rellotge.inici();		
	}
} 

/**
 * Classe Rellotge. La classe interna es crea anònima a un mètode i per tant una única vegada
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 * 
 */
class RellotgeInternaAnonima {
	private int interval;
	private Date data; //accessible des de la classe interna
	public RellotgeInternaAnonima(int interval) {
		this.interval = interval;

	}

	public void inici() {
		/**
		 * Classe Interna anònima (callback) que implementa ActionListener
		 * 
		 * @author sergi grau
		 * @version 1.0, 18.01.2010
		 * 
		 */
	
		ActionListener esdeveniment = new ActionListener(){
			public void actionPerformed(ActionEvent event) {	
				data = new Date(); //atribut de la classe externa
				System.out.println(data);
			}
		};
		Timer t = new Timer(interval, esdeveniment);
		t.start();
		JOptionPane.showMessageDialog(null, "Voleu acabar el rellotge?");
		System.exit(0);
	}

	
}

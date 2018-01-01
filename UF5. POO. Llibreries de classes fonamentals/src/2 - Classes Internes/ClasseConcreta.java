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
public class ClasseConcreta {
	public static void main(String[] agrs) {
		RellotgeConcreta rellotge = new RellotgeConcreta(1000);
		rellotge.inici();		
	}
}

/**
 * Classe Rellotge
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 * 
 */
class RellotgeConcreta {
	private int interval;
	public RellotgeConcreta(int interval) {
		this.interval = interval;

	}

	public void inici() {
		ActionListener esdeveniment = new Esdeveniment();
		Timer t = new Timer(interval, esdeveniment);
		t.start();
		JOptionPane.showMessageDialog(null, "Voleu acabar el rellotge?");
		System.exit(0);
	}
}

/**
 * Classe Interna (callback) que implementa ActionListener
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 * 
 */
class Esdeveniment implements ActionListener {
	public void actionPerformed(ActionEvent event) {	
		Date data = new Date();
		System.out.println(data);
	}
}

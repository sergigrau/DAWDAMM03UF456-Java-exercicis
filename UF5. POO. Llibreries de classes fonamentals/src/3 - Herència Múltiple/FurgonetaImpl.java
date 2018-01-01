/**
 * Classe que representa una entitat Furgoneta. I hereta de Vehicle i implementa
 * la interf’cie Furgoneta
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 */
public class FurgonetaImpl extends Vehicle implements Furgoneta {

	private boolean portaLateral;
	private int PMA;

	/**
	 * Constructor amb 5 parˆmetres
	 * 
	 * @param model
	 * @param potencia
	 * @param color
	 * @param portaLateral
	 * @param pMA
	 */
	public FurgonetaImpl(String model, int potencia, String color,
			boolean portaLateral, int pMA) {
		super(model, potencia, color);
		this.portaLateral = portaLateral;
		PMA = pMA;
	}

	
	@Override
	public int getPMA() {

		return PMA;
	}

	@Override
	public boolean isPortaLateral() {
		return portaLateral;
	}

	@Override
	public String toString() {
		return super.toString() + portaLateral + "\t" + PMA;
	}
}

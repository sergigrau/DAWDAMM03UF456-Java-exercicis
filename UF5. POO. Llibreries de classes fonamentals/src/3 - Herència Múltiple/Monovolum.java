/**
 * Classe que representa una entitat Monovolum. implementa la interfície
 * Furgoneta i hereta de Cotxe, per la qual cosa presenta herència múltiple
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 */
public class Monovolum extends Cotxe implements Furgoneta {

	private boolean separador;
	private FurgonetaImpl furgonetaDelegacio = null;

	/**
	 * Constructor amb 6 paràmetres
	 * 
	 * @param model
	 * @param potencia
	 * @param color
	 * @param nombrePortes
	 * @param nombrePlaces
	 * @param separador
	 */
	public Monovolum(String model, int potencia, String color,
			int nombrePortes, int nombrePlaces, boolean portaLateral, int PMA,
			boolean separador) {
		super(model, potencia, color, nombrePortes, nombrePlaces);
		this.separador = separador;
		furgonetaDelegacio = new FurgonetaImpl(model, potencia, color,
				portaLateral, PMA);
	}

	/**
	 * 
	 * @return
	 */
	public boolean getSeparador() {
		return separador;
	}

	@Override
	public int getPMA() {
		return furgonetaDelegacio.getPMA();
	}

	@Override
	public boolean isPortaLateral() {
		return furgonetaDelegacio.isPortaLateral();
	}

}

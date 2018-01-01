/**
 * Classe cotxe que hereta de Vehicle
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 */
public class Cotxe extends Vehicle {
	private int nombrePortes;
	private int nombrePlaces;

	/**
	 * Constructor amb 5 paràmetres
	 * 
	 * @param model
	 * @param potencia
	 * @param color
	 * @param nombrePortes
	 * @param nombrePlaces
	 */
	public Cotxe(String model, int potencia, String color, int nombrePortes,
			int nombrePlaces) {
		super(model, potencia, color);
		this.nombrePortes = nombrePortes;
		this.nombrePlaces = nombrePlaces;
	}

	/** Mètode accessor que retorna el nombre de portes
	 * @return el nombrePortes
	 */
	public int getNombrePortes() {
		return nombrePortes;
	}

	/** Mètode accessor que retorna el nombre de places
	 * @return el nombrePlaces
	 */
	public int getNombrePlaces() {
		return nombrePlaces;
	}
	
	@Override
	public String toString() {
		return super.toString()+nombrePlaces+"\t"+nombrePortes;
	}
}

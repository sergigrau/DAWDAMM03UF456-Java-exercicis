/**
 * Classe que representa una entitat Camio
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 */
public class Camio extends Vehicle {
	private int TARA;
	private int PMA;
	private int numeroEixos;
	/**
	 * Constructor amb 6 paràmetres
	 * @param model
	 * @param potencia
	 * @param color
	 * @param tARA
	 * @param pMA
	 * @param numeroEixos
	 */
	public Camio(String model, int potencia, String color, int tARA, int pMA,
			int numeroEixos) {
		super(model, potencia, color);
		TARA = tARA;
		PMA = pMA;
		this.numeroEixos = numeroEixos;
	}
	
	/**  Mètode accessor que retorna la TARA
	 * @return TARA
	 */
	public int getTARA() {
		return TARA;
	}

	/**  Mètode accessor que retorna PMA
	 * @return pMA
	 */
	public int getPMA() {
		return PMA;
	}

	/**  Mètode accessor que retorna el numeroEixos
	 * @return numeroEixos
	 */
	public int getNumeroEixos() {
		return numeroEixos;
	}

	@Override
	public String toString() {
		return super.toString()+TARA+"\t"+PMA+"\t"+numeroEixos;
	}
}

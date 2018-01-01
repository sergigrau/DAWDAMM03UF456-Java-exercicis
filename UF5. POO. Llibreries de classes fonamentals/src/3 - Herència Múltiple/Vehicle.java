/**
 * Classe abstracta que representa un Vehicle
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 */
public abstract class Vehicle implements Comparable<Vehicle> {
	private String model;
	private int potencia;
	private String color;
	private Matricula matricula;

	/**
	 * Constructor amb 3 parˆmetres
	 * 
	 * @param model
	 * @param potencia
	 * @param color
	 */
	public Vehicle(String model, int potencia, String color) {
		super();
		this.model = model;
		this.potencia = potencia;
		this.color = color;
	}

	/**
	 * Mtode accessor que retorna el model
	 * 
	 * @return el model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Mtode accessor que retorna la potncia
	 * 
	 * @return la potencia
	 */
	public int getPotencia() {
		return potencia;
	}

	/**
	 * Mtode accessor que retorna el color
	 * 
	 * @return el color
	 */
	public String getColor() {
		return color;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Vehicle copia = (Vehicle) super.clone();
		// copiem els camps mutables
		copia.matricula = (Matricula) matricula.clone();
		return copia;
		
	}

	/**
	 * Dos Cotxes s—n iguals si tenen la mateixa Matricula
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle v = (Vehicle) obj;
		return matricula.equals(v.matricula);
	}

	@Override
	public String toString() {
		return super.toString() + "-" + model + "\t" + potencia + "\t" + color;
	}

	@Override
	public int compareTo(Vehicle o) {
		//alternativament return potencia - o.potencia;
		if (potencia > o.potencia)
			return 1;
		else if (potencia < o.potencia)
			return -1;
		else
			return 0;
	}

}

/** Classe DNI. permet representar el DNI de persones*/
public class DNI {
	//declaraci� d'atributs
	/**atribut protegit que representa el n�mero de DNI*/
  	protected int numero;
	
	/**M�tode accessor per obtenir el n�mero de DNI
	 * @return n�mero de DNI
	 */
  	public int getDNI() {
  		return numero;
  	}
  	/**M�tode accessor d'escriptura per assignar el n�mero de DNI
  	 * @param num N�mero de DNI
  	 */
  	public void setDNI(int num) {
  		numero=num;
  	}
}
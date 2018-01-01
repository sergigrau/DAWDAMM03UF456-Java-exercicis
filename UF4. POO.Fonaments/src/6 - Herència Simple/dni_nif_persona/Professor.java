/**Classe que recull els atributs i m�todes del TAD Professor*/
public class Professor extends Persona {
	/**Atribut protegit per el sou d'un Professor*/
  	protected double sou;
	/**M�tode accessor de lectura del sou
	 * @return retorna el sou del Professor
	 */
  	public double getSou() {
  		return sou;
  	}
  	/**Accessor d'escriptura de l'atribut sou
  	 * @param sou Sou del Professor
  	 */
  	public void setSou(double s) {
  		sou=s;
  	}
  	/**Redefinici� del m�tode toString de Persona. Presenta el nom del Professor
  	 * i el seu Sou
  	 */
  	public String toString() {
  		return "Professor: "+getNom()+ " amb sou " +getSou();
  	}
}
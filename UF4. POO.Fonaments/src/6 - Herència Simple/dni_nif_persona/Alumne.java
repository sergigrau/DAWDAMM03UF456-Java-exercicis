/**Classe que defineix un Alumne.*/
public class Alumne extends Persona {
	//declaració d'atributs
	/**atribut protegit que representa el número de l'alumne*/
  	protected int numAlumne;

	@Override
	public String toString() {
  		return "Alumne: "+getNom()+" amb numero "+getNumAlumne();
  	}
  	
  	/**M�tode accessor de lectura que retorna el numero de l'alumne 
  	 * @return Numero de l'alumne
  	 */
  	public int getNumAlumne() {
  		return numAlumne;
  	}
  	/**M�tode accessor d'escriptura. permet assignar el n�mero de l'alumne
  	 * @param num Numero de l'alumne
  	 */
 	public void setNumAlumne(int num) {
  		numAlumne=num;
  	}
}
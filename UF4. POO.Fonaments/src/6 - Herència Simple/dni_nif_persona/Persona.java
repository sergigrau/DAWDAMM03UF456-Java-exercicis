/**Classe que representa una entitat Persona. Aquesta hauria de ser una classe
 * abstracta doncs en el nostre domini no la necessitem, només representa una
 * serie d'atributs i operacions comunes
 * @author sergi
 */
public class Persona {
	/**Atribut protegit. Conté el nom d'una Persona*/
  	protected String nom;
 	/**atribut pel nif d'una Persona*/
  	protected NIF nif;
	/**Métode redefinit presenta el nom de la Persona i el seu NIF
	 * @return retorna el nom i NIF d'una Persona
	 */
        @Override
  	public String toString() {
  		return "Persona: "+getNom()+" amb NIF num "+getNIF();
  	}
  	/**Accessor de lectura de l'atribut nom
  	 * @return el nom de la Persona
  	 */
  	public String getNom() {
  		return nom;
  	}
  	/**Accessor d'escriptura del nom
  	 * @param n el nom a assignar
  	 */
  	public void setNom(String n) {
  		nom=n;
  	}
  	/**Accessor de lectura del NIF
  	 * @return retorna el NIF
  	 */
  	public NIF getNIF() {
  		return nif;
  	}
  	/**Accessor d'escriptura del NIF
  	 * @param numNIF és passa un DNI. cridem el constructor de NIF
  	 * amb un paràmetre què és el DNI
  	 */
  	public void setNIF(int numNIF) {
  		nif=new NIF(numNIF);
  	}
  	@Override
  	public boolean equals(Object objecte){
  	    if(this==objecte) return true;
            if(objecte==null) return false;
            if(!(objecte instanceof Persona)) return false;
            if (!nif.equals(((Persona)objecte).getNIF())) return false;

            return true;
  	}
}
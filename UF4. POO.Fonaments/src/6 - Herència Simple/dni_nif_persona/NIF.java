/** Classe NIF hereta de DNI. Permet representar un objecte NIF*/
public class NIF extends DNI{
	//declaraci� d'atributs
	/**Atribut privat per emmagatzemar la lletra del NIF*/
	private char lletra;

	
	/** Construtor de la classe amb un par�metre
	 * @param xifres correspon al dni. Construeix un objecte NIF passant-li
	 * com a par�metre un n�mero de DNI
	 */
	public NIF(int xifres) {
		setDNI(xifres);
		lletra=calculaLletra();
		}
	@Override
	public String toString() {
		return getDNI()+"-"+getLletra();
	}
	/**M�tode que retorna la lletra que li correspon al objecte NIF
	 * @return retorna la lletra del NIF
	 */
	public char getLletra() {
		return lletra;
	}
	/**M�tode privat que permet calcular la lletra d'un NIF 
	 * @return retorna la lletra que li correspon a un DNI
	 */
	private char calculaLletra() {
		/*Array de caracters. S'utilitza per determinar la lletra que correspon
		 * al DNI */
	    char[] taula={ 'T','R','W','A','G','M','Y','F','P','D','X',
	    		'B','N','J','Z','S','Q','V','H','L','C','K','E'};
		return taula[getDNI()%23];
	}
        private char calculaLletra2() {

	    String taula="TRWAGMYFPDXBNJZSQVHLCKE";
		return taula.charAt(getDNI()%23);
	}

        @Override
	public boolean equals(Object obj){
	    if (this==obj) return true;
            if (obj==null) return false;
            if (getClass() != obj.getClass()) return false;
            if (numero!=((NIF)obj).numero) return false;
            return true;
	}
	
}
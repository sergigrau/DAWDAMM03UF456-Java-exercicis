import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe entitat que representa a un empleat temps complert en el model del domini
 *
 * @author sergi grau
 * @version 1.0 10.04.2013
 */
@Entity
public class EmpleatTempsComplert extends EmpleatCompanyia {
    private long salari;
    private long pensio;
   

    public EmpleatTempsComplert() {
    
    }

    public long getSalari() {
        return salari;
    }

    public void setSalari(long salari) {
        this.salari = salari;
    }

    public long getPensio() {
        return pensio;
    }

    public void setPensio(long pensio) {
        this.pensio = pensio;
    }

    @Override
    public String toString() {
        return "EmpleatTempsComplert{" + "salari=" + salari + ", pensio=" + pensio + '}';
    }
    
}

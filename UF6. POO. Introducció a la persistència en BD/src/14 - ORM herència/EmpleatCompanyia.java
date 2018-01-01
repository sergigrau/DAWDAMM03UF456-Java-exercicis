import javax.persistence.MappedSuperclass;

/**
 * Classe entitat que representa a un empleat de la companyia en el model del domini
 * 
 *
 * @author sergi grau
 * @version 1.0 10.04.2013
 */
@MappedSuperclass
public abstract class EmpleatCompanyia extends Empleat {
    private int diesVacances;

    public EmpleatCompanyia(){
        
    }

      
    public int getDiesVacances() {
        return diesVacances;
    }

    public void setDiesVacances(int diesVacances) {
        this.diesVacances = diesVacances;
    }
    
}

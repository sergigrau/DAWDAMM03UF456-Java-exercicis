import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe entitat que representa a un empleat extern en el model del domini
 *
 * @author sergi grau
 * @version 1.0 10.04.2013
 */
@Entity
public class EmpleatTempsParcial extends EmpleatCompanyia {
     @Column(name="PREU_H")
    private float preuHora;
   

    public EmpleatTempsParcial() {
    }


    public float getPreuHora() {
        return preuHora;
    }

    public void setPreuHora(float preuHora) {
        this.preuHora = preuHora;
    }

    @Override
    public String toString() {
        return "EmpleatTempsParcial{" + "preuHora=" + preuHora + '}';
    }

   
}

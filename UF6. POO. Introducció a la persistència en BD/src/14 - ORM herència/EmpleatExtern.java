import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe entitat que representa a un empleat extern en el model del domini
 *
 * @author sergi grau
 * @version 1.0 10.04.2013
 */
@Entity
public class EmpleatExtern extends Empleat {
    @Column(name="COST")
    private float costDiari;
    private int dies;
   

    public EmpleatExtern() {
    }
     public EmpleatExtern(int id) {
         super(id);
    }

    public float getCostDiari() {
        return costDiari;
    }

    public void setCostDiari(float costDiari) {
        this.costDiari = costDiari;
    }

    public int getDies() {
        return dies;
    }

    public void setDies(int dies) {
        this.dies = dies;
    }
    
    @Override
    public String toString() {
        return "EmpleatExtern{" + "costDiari=" + costDiari + ", dies=" + dies + '}';
    }

   
}

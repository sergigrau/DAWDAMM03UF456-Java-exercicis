import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe entitat que representa a un empleat en el model del domini
 *
 * @author sergi grau
 * @version 1.0 10.04.2013
 */
@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Empleat  {
    
    @Id private int id;
    private String nom;
    @Temporal(TemporalType.DATE)
    @Column(name="CONTRACTE")
    private Date dataContracte;

    public Empleat() {
    }

    public Empleat(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDataContracte() {
        return dataContracte;
    }

    public void setDataContracte(Date dataContracte) {
        this.dataContracte = dataContracte;
    }

    @Override
    public String toString() {
        return "Empleat{" + "id=" + id + ", nom=" + nom + ", dataContracte=" + dataContracte + '}';

    } 
}

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe entitat que representa a un empleat en el model del domini
 *
 * @author sergi grau
 * @version 1.0 29.02.2012
 */
@Entity
public class Empleat {

    @Id
    private int id;
    private String nom;
    private long salari;

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

    public long getSalari() {
        return salari;
    }

    public void setSalari(long salari) {
        this.salari = salari;
    }

    @Override
    public String toString() {
        return "Empleat{" + "id=" + id + ", nom=" + nom + ", salari=" + salari + '}';
    }
    
}

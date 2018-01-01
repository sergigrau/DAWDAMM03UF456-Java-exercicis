import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Classe entitat que representa a un departament en el model del domini.
 * Utilitza relacions ORM
 *
 * @author sergi grau
 * @version 1.0 05.04.2014
 */

@Entity
@Access(AccessType.FIELD)
public class Departament {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
   private String nom;

   
 @OneToMany(cascade=CascadeType.PERSIST , mappedBy = "departament")
 private List<Empleat> empleats=new ArrayList<Empleat>();
 
    public Departament() {
        
    }

    public Departament(String nom) {
        this.nom = nom;
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

    public List<Empleat> getEmpleats() {
        return empleats;
    }

    public void setEmpleats(List<Empleat> empleats) {
        this.empleats = empleats;
    }

    @Override
    public String toString() {
        return "Departament{" + "id=" + id + ", nom=" + nom + '}';
    }
   
}

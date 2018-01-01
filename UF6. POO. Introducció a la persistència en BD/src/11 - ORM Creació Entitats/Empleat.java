import javax.persistence.*;

/**
 * Classe entitat que representa a un empleat en el model del domini. Utilitza
 * relacions ORM
 *
 * @author sergi grau
 * @version 1.0 05.04.2014
 */
@Entity
@Access(AccessType.FIELD)
public class Empleat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private long salari;
    
    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private Departament departament;

     @OneToOne
    @JoinColumn(name="APARC_ID")
    private Aparcament aparcament;
     
    public Empleat() {
    }

    public Empleat(String nom, long salari) {

        this.nom = nom;
        this.salari = salari;
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

    public Aparcament getAparcament() {
        return aparcament;
    }

    public void setAparcament(Aparcament aparcament) {
        this.aparcament = aparcament;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    
    @Override
    public String toString() {
        return "Empleat{" + "id=" + id + ", nom=" + nom + ", salari=" + salari + '}';
    }
}

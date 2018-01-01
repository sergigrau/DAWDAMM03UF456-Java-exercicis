import javax.persistence.*;

/**
 * Classe entitat que representa a un Aparcament en el model del domini.
 * Utilitza relacions ORM
 *
 * @author sergi grau
 * @version 1.0 05.03.2012
 */
@Entity
@Access(AccessType.FIELD)
public class Aparcament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ubicacio;

     @OneToOne(mappedBy="aparcament")
    private Empleat empleat;
     
    public Aparcament() {
    }

    public Aparcament(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    @Override
    public String toString() {
        return "Aparcament{" + "id=" + id + ", ubicacio=" + ubicacio + '}';
    }
}

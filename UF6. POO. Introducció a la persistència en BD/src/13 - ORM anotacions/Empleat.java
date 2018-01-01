import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * Classe entitat que representa a un empleat en el model del domini Utilitza
 * anotacions per a personalitzar el mapatge
 *
 * @author sergi grau
 * @version 1.0 05.03.2012
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "EMP", schema = "PROVA")
public class Empleat implements Serializable {

    public static final String CODI_LOCAL = "34";
    private int id;
    private String nom;
    private long salari;
    private String telefon;
    private Date dataContracte;
    private TipusEmpleat tipusEmpleat;
    
    public Empleat() {
    }


    public Empleat(String nom, long salari, String telefon) {
     
        this.nom = nom;
        this.salari = salari;
        this.telefon = telefon;
    }

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
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

    @Column(name = "SAL")
    public long getSalari() {
        return salari;
    }

    public void setSalari(long salari) {
        this.salari = salari;
    }

    @Transient
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDataContracte() {
        return dataContracte;
    }

    public void setDataContracte(Date dataContracte) {
        this.dataContracte = dataContracte;
    }
     @Enumerated(EnumType.STRING)
    public TipusEmpleat getTipusEmpleat() {
        return tipusEmpleat;
    }

    public void setTipusEmpleat(TipusEmpleat tipusEmpleat) {
        this.tipusEmpleat = tipusEmpleat;
    }

    @Column(name = "TELF")
    protected String getTelefonBD() {
        if (telefon.length() == 11) {
            return telefon;
        } else {
            return CODI_LOCAL + telefon;
        }
    }

    protected void setTelefonBD(String num) {
        if (num.startsWith(CODI_LOCAL)) {
            telefon = num.substring(3);
        } else {
            telefon = num;
        }
    }

    @Override
    public String toString() {
        return "Empleat{" + "id=" + id + ", nom=" + nom + ", salari=" + salari + '}';
    }
}

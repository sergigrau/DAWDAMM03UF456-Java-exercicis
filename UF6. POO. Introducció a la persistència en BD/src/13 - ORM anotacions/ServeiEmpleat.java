import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author sergi
 */
public class ServeiEmpleat {

    protected EntityManager em;

    public ServeiEmpleat(EntityManager em) {
        this.em = em;
    }

    public Empleat crearEmpleat(String nom, long salari, String telefon, Date data, TipusEmpleat tipus) {
        Empleat emp = new Empleat();
        emp.setNom(nom);
        emp.setSalari(salari);
        emp.setTelefon(telefon);
        emp.setDataContracte(data);
        emp.setTipusEmpleat(tipus);
        em.persist(emp);
        return emp;
    }

    public void esborrarEmpleat(int id) {
        Empleat emp = trobarEmpleat(id);
        if (emp != null) {
            em.remove(emp);
        }
    }

    public Empleat augmentarSalariEmpleat(int id, long augment) {
        Empleat emp = em.find(Empleat.class, id);
        if (emp != null) {
            emp.setSalari(emp.getSalari() + augment);
        }
        return emp;
    }

    public Empleat trobarEmpleat(int id) {
        return em.find(Empleat.class, id);
    }

    public List<Empleat> trobarTotsEmpleats() {
        TypedQuery<Empleat> query = em.createQuery(
                "SELECT e FROM Empleat e", Empleat.class);
        return query.getResultList();
    }
}

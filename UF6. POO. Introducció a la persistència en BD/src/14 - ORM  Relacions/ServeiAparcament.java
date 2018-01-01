import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author sergi
 */
public class ServeiAparcament {

    protected EntityManager em;

    public ServeiAparcament(EntityManager em) {
        this.em = em;
    }

    public Aparcament crearAparcament(String ubicacio) {
        Aparcament ap = new Aparcament();
        ap.setUbicacio(ubicacio);
        em.persist(ap);
        return ap;
    }

    public void esborrarAparcament(int id) {
        Aparcament emp = trobarAparcament(id);
        if (emp != null) {
            em.remove(emp);
        }
    }


    public Aparcament trobarAparcament(int id) {
        return em.find(Aparcament.class, id);
    }

    public List<Aparcament> trobarTotsAparcaments() {
        TypedQuery<Aparcament> query = em.createQuery(
                "SELECT e FROM Aparcament e", Aparcament.class);
        return query.getResultList();
    }
}

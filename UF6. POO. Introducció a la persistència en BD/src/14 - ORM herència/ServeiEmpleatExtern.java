import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Classe que implementa el Servei de persitència d'empleat
 * @author sergi grau
 * @version 1.0 10.04.2013
 */
public class ServeiEmpleatExtern {

    protected EntityManager em;

    public ServeiEmpleatExtern(EntityManager em) {
        this.em = em;
    }

    public Empleat crearEmpleat(int id, String nom, Date dataContracte) {
        Empleat emp = new EmpleatExtern(id);
        emp.setNom(nom);
        emp.setDataContracte(dataContracte);
        em.persist(emp);
        return emp;
    }

    public void esborrarEmpleat(int id) {
        Empleat emp = trobarEmpleat(id);
        if (emp != null) {
            em.remove(emp);
        }
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

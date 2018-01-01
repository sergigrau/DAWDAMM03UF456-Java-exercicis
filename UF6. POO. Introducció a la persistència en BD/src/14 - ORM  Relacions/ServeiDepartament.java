import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author sergi
 */
public class ServeiDepartament {

    protected EntityManager em;

    public ServeiDepartament(EntityManager em) {
        this.em = em;
    }

    public Departament crearDepartament(String nom) {
        Departament dep = new Departament();
        dep.setNom(nom);
        em.persist(dep);
        return dep;
    }

    public void esborrarDepartament(int id) {
        Departament emp = trobarDepartament(id);
        if (emp != null) {
            em.remove(emp);
        }
    }


    public Departament trobarDepartament(int id) {
        return em.find(Departament.class, id);
    }

    public List<Departament> trobarTotsDepartaments() {
        TypedQuery<Departament> query = em.createQuery(
                "SELECT e FROM Departament e", Departament.class);
        return query.getResultList();
    }
}

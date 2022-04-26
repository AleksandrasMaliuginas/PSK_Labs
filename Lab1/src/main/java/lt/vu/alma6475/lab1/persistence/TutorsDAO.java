package lt.vu.alma6475.lab1.persistence;

import lt.vu.alma6475.lab1.entity.Tutor;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TutorsDAO {

    @Inject
    private EntityManager em;

    public List<Tutor> loadAll() {
        return em.createNamedQuery("Tutor.findAll", Tutor.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Tutor tutor){
        this.em.persist(tutor);
    }

    public Tutor findOne(Integer id) {
        return em.find(Tutor.class, id);
    }
}

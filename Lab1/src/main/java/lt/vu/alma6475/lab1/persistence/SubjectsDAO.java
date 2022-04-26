package lt.vu.alma6475.lab1.persistence;

import lt.vu.alma6475.lab1.entity.Student;
import lt.vu.alma6475.lab1.entity.Subject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SubjectsDAO {

    @Inject
    private EntityManager em;

    public void persist(Subject subject){
        this.em.persist(subject);
    }

    public Subject findOne(Integer id){
        System.out.println(em.find(Subject.class, id).getStudents().size());
        return em.find(Subject.class, id);
    }

    public Subject update(Subject subject){
        return em.merge(subject);
    }

    public List<Subject> loadAll() {
        return em.createNamedQuery("Subject.findAll", Subject.class).getResultList();
    }
}

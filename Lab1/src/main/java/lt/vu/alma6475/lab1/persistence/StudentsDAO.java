package lt.vu.alma6475.lab1.persistence;

import lt.vu.alma6475.lab1.entity.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StudentsDAO {

    @Inject
    private EntityManager em;

    public void persist(Student player){
        this.em.persist(player);
    }

    public Student findOne(Integer id){
        return em.find(Student.class, id);
    }

    public Optional<Student> findOne(String name) {
        return em.createNamedQuery("Student.findByName", Student.class).setParameter("name", name).getResultList().stream().findFirst();
    }

    public Student update(Student player){
        return em.merge(player);
    }
    public List<Student> loadAll() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }
}

package lt.vu.alma6475.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.alma6475.lab1.alternatives.Greeting;
import lt.vu.alma6475.lab1.decorators.TextDecorator;
import lt.vu.alma6475.lab1.entity.Subject;
import lt.vu.alma6475.lab1.persistence.SubjectsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Subjects {

    @Inject
    private SubjectsDAO subjectsDAO;

    @Getter @Setter
    private Subject subjectToCreate = new Subject();

    @Getter
    private List<Subject> allSubjects;

    @Inject @Getter
    private Greeting greeting;

    @Inject @Getter
    private TextDecorator textDecorator;

    @PostConstruct
    public void init(){
        loadAllTeams();
    }

    @Transactional
    public void createSubject(){
        this.subjectsDAO.persist(subjectToCreate);
    }

    private void loadAllTeams(){
        this.allSubjects = subjectsDAO.loadAll();
    }
}

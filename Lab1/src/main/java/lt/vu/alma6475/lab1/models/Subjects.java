package lt.vu.alma6475.lab1.models;

import lombok.Getter;
import lombok.Setter;
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
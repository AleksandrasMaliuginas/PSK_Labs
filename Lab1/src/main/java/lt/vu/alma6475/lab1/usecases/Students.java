package lt.vu.alma6475.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.alma6475.lab1.entity.Student;
import lt.vu.alma6475.lab1.persistence.StudentsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Students {

    @Inject
    private StudentsDAO studentsDAO;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @Getter
    private List<Student> allStudents;

    @PostConstruct
    public void init(){
        loadAllTeams();
    }

    @Transactional
    public void createTeam(){
        this.studentsDAO.persist(studentToCreate);
    }

    private void loadAllTeams(){
        this.allStudents = studentsDAO.loadAll();
    }
}

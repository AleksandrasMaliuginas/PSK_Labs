package lt.vu.alma6475.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.alma6475.lab1.entity.Student;
import lt.vu.alma6475.lab1.entity.Subject;
import lt.vu.alma6475.lab1.entity.Tutor;
import lt.vu.alma6475.lab1.persistence.StudentsDAO;
import lt.vu.alma6475.lab1.persistence.SubjectsDAO;
import lt.vu.alma6475.lab1.persistence.TutorsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

@Model
public class SubjectPage implements Serializable {

    @Inject
    private SubjectsDAO subjectsDAO;

    @Inject
    private TutorsDAO tutorsDAO;

    @Inject
    private StudentsDAO studentsDAO;

    @Getter @Setter
    private Subject subject;

    @Getter @Setter
    private Student studentToAdd = new Student();
    @Getter @Setter
    private Tutor tutorToAdd = new Tutor();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer subjectId = Integer.parseInt(requestParameters.get("subjectId"));
        this.subject = subjectsDAO.findOne(subjectId);
    }

    @Transactional
    public void addStudent() {
        Optional<Student> existingStudent = studentsDAO.findOne(studentToAdd.getName());
        if (existingStudent.isPresent()) {
            studentToAdd = existingStudent.get();
        } else {
            studentsDAO.persist(studentToAdd);

        }

        this.subject.getStudents().add(studentToAdd);
        subjectsDAO.persist(this.subject);
    }

    @Transactional
    public void addTutor() {
        tutorsDAO.persist(tutorToAdd);
        this.subject.setTutor(tutorToAdd);
        subjectsDAO.persist(this.subject);
    }
}

package lt.vu.alma6475.lab1.models;

import lombok.Getter;
import lombok.Setter;
import lt.vu.alma6475.lab1.entity.Student;
import lt.vu.alma6475.lab1.entity.Tutor;
import lt.vu.alma6475.lab1.persistence.StudentsDAO;
import lt.vu.alma6475.lab1.persistence.SubjectsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

@Model
public class StudentPage implements Serializable {
    @Inject
    private StudentsDAO studentsDAO;

    @Inject
    private SubjectsDAO subjectsDAO;

    @Getter @Setter
    private Student student;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer studentID = Integer.parseInt(requestParameters.get("studentId"));
        this.student = studentsDAO.findOne(studentID);
    }
}

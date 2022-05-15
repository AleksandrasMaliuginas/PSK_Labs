package lt.vu.alma6475.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.alma6475.lab1.entity.Student;
import lt.vu.alma6475.lab1.interceptors.LoggedInvocation;
import lt.vu.alma6475.lab1.persistence.StudentsDAO;
import lt.vu.alma6475.lab1.persistence.SubjectsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
@ViewScoped
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
        System.out.println("INIT studentId = " + requestParameters.get("studentId"));
        Integer studentID = Integer.parseInt(requestParameters.get("studentId"));
        this.student = studentsDAO.findOne(studentID);
    }


    @LoggedInvocation
    @Transactional
    public String updateStudentName(){
        System.out.println("Stud ID: " + this.student.getId());
        try{
            studentsDAO.update(this.student);
        } catch (OptimisticLockException e){
            System.out.println(this.student.getId());
            return "/studentPage.xhtml?faces-redirect=true&studentId=" + this.student.getId() + "&error=optimistic-lock-exception";
        }
        return "studentPage.xhtml?studentId=" + this.student.getId() + "&faces-redirect=true";
    }
}

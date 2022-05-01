package lt.vu.alma6475.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.alma6475.lab1.mybatis.dao.SubjectMapper;
import lt.vu.alma6475.lab1.mybatis.model.Subject;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
@RequestScoped
public class SubjectsMyBatis {
    @Inject
    private SubjectMapper subjectMapper;

    @Getter
    private List<Subject> allSubjects;

    @Getter @Setter
    private Subject subjectToCreate = new Subject();

    @PostConstruct
    public void init() {
        this.loadAllSubjects();
    }

    private void loadAllSubjects() {
        this.allSubjects = subjectMapper.selectAll();
    }

    @Transactional
    public String createSubject() {
        subjectMapper.insert(subjectToCreate);
        return "/myBatis/subjects?faces-redirect=true";
    }
}

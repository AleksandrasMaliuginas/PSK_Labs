package lt.vu.alma6475.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.alma6475.lab1.mybatis.dao.SubjectMapper;
import lt.vu.alma6475.lab1.mybatis.model.Subject;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
@RequestScoped
public class SubjectPageMyBatis {
    @Inject
    private SubjectMapper subjectMapper;

    @Getter
    private Subject subject;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer subjectId = Integer.parseInt(requestParameters.get("subjectId"));
        this.subject = subjectMapper.selectByPrimaryKey(subjectId);
    }
//
//    @Transactional
//    public String createSubject() {
//        subjectMapper.insert(subjectToCreate);
//        return "/myBatis/subjects?faces-redirect=true";
//    }
}

package lt.vu.alma6475.lab1.usecases;

import lt.vu.alma6475.lab1.interceptors.LoggedInvocation;
import lt.vu.alma6475.lab1.services.StudentIdGenerator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateStudentId implements Serializable {

    @Inject
    StudentIdGenerator studentIdGenerator;

    private CompletableFuture<Integer> studentIdGeneratorTask = null;

    @LoggedInvocation
    public String generateStudentId(){
//        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        studentIdGeneratorTask = CompletableFuture.supplyAsync(() -> studentIdGenerator.generateId());

//        return "/studentPage.xhtml?faces-redirect=true&albumId=" + requestParameters.get("albumId");
        return "/index.xhtml?faces-redirect=true";
    }

    public boolean isGenerating(){
        return studentIdGeneratorTask != null && !studentIdGeneratorTask.isDone();
    }

    public String getGenerationStatus() throws ExecutionException, InterruptedException {
        if (studentIdGeneratorTask == null) {
            return null;
        } else if (isGenerating()){
            return "ID generation is in progress...";
        }
        return "Student ID: " + studentIdGeneratorTask.get();
    }
}

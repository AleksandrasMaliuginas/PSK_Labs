package lt.vu.alma6475.lab1.alternatives;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
public class MyApplicationStatus extends ApplicationStatus {
    public String getStatus() {
        return "SPECIALIZED";
    }
}

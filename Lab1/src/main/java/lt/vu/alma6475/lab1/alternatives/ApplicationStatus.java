package lt.vu.alma6475.lab1.alternatives;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
public class ApplicationStatus {
    public String getStatus() {
        return "DEFAULT";
    }
}

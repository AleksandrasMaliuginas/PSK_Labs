package lt.vu.alma6475.lab1.alternatives;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

@Dependent
@Alternative
public class LithuanianGreeting implements Greeting {
    @Override
    public String sayHello() {
        return "Laba diena!";
    }

    public LithuanianGreeting(){

    }
}

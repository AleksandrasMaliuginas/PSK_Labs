package lt.vu.alma6475.lab1.alternatives;

import javax.enterprise.context.Dependent;

@Dependent
public class EnglishGreeting implements Greeting {

    @Override
    public String sayHello() {
        return "Hello!";
    }

    public EnglishGreeting(){
    }
}

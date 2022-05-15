package lt.vu.alma6475.lab1.decorators;

import javax.enterprise.context.Dependent;

@Dependent
public class Decorator implements TextDecorator {

    @Override
    public String DecoratedName(String name) {
        return name;
    }
}

package lt.vu.alma6475.lab1.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class DecoratorImpl implements TextDecorator {

    @Inject @Delegate @Any
    TextDecorator textDecorator;

    public String DecoratedName(String name){
        return "***" + textDecorator.DecoratedName(name) + "***";
    }

}

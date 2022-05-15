package lt.vu.alma6475.lab1.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class StudentIdGenerator implements Serializable {

    public Integer generateId(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.out.println();
        }
        return new Random().nextInt(999999);
    }

}

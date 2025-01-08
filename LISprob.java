
// Parent class Vehicle which has methods to return the number of wheels and check if engine is there

import java.util.ArrayList;
import java.util.List;

class Vehicle{
    public Integer numOfWheels(){
        return 4;
    }
    public Boolean hasEngine(){
        return true;
    }
}

// Car being a child class of Vehicle
class Car extends Vehicle{

}

class Bike extends Vehicle{
    @Override
    public Integer numOfWheels(){
        return 2;
    }
}

class Cycle extends Vehicle{
    @Override
    public Boolean hasEngine(){
        return null;
    }
}

public class LISprob {
    public static void main(String[] args) {
        System.out.println("working code");
        Bike b1 = new Bike();
        System.out.println(b1.numOfWheels());
        System.out.println(b1.hasEngine());
        Car c1 = new Car();
        System.out.println(c1.numOfWheels());
        // till now the code works fine since all the child class can be substituted on the parent class which doesnt alter the logic

        //  if another child class bicycle which returns null for "hasEngine" is added, will disrupt the code
        Cycle c2 = new Cycle();
        System.out.println(c2.hasEngine());
        List<Vehicle> vlist = new ArrayList<>();
        vlist.add(b1);
        vlist.add(c1);
        // vlist.add(c2);
        // since c2.hasEngine returns null and using toString() on a null will raise exception 
        System.out.println("list working: ");
        for(Vehicle i:vlist){
            System.out.println(i.hasEngine().toString());
        }

    }
}
// To resolve this make sure that the parent class only methods that dont disturb the working
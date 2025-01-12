// strategy pattern enables select one algorithm at a time
//it defines a family of algorithms with each class and can be integrated in to a common interface
// in real life example say there is a navigation app that supports multiple modes of transmission , that includes driving walking biking and public transport, 
// each routing algo can be implemented as a separate strategy to caclulcate routes based on the user's selected mode of transportation 
// the strategy pattern shuld always have a common interface, concreate strtegis, context class
// common interface is the interface that is built
// strategies include the types of way in which the route can be defined
// context class uses the strategies 

//1. defining the Route strategy interface

interface RouteStrategy {
    void calculate(String origin, String dest);
    
}

//2. Concrete strategies

class DrivingRoute implements RouteStrategy{
    @Override
    public void calculate(String origin, String dest){
        System.out.println("calculating driving route from "+origin+" to "+dest);
    }
}

class WalkingRoute implements RouteStrategy{
    @Override
    public void calculate(String origin, String dest){
        System.out.println(" calculating walking route from "+origin+" to "+dest);
    }
}
class CyclingRoute implements RouteStrategy{
    @Override
    public void calculate(String origin, String dest){
        System.out.println(" calculating Cycling route from "+origin+" to "+dest);
    }
}



// 3. creating context class
 class NavigationApp{
    // creating variable of interface
    public RouteStrategy r1;
    // method to set the current route strategy
    public void setRoute(RouteStrategy r1){
        this.r1=r1;
    }

    // method to execute selected strategy
    public void calculate(String origin, String dest){
        r1.calculate(origin, dest);
    }

}

// main class

public class StrategyPattern{
    public static void main(String[] args) {
        NavigationApp app = new NavigationApp();
        app.setRoute(new CyclingRoute());
        app.calculate("chennai", "Thanjavur");
        
        app.setRoute(new WalkingRoute());
        app.calculate("chennai", "Thanjavur");
        
        app.setRoute(new DrivingRoute());
        app.calculate("chennai", "Thanjavur");
        
    }

}
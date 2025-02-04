package com.mphasisJava.MyDemoProject;

// This pattern is used in updating behaviour dynamically without changing its existing structure

// 1. create base interface


interface Pizza{
	String getDescription();
	double getCost();
}

//2. create Concreate Component

class MargaritaPizza implements Pizza{
	public String getDescription() {
		return "Margarita Pizza";

	}
	public double getCost(){
		return 200.0;
	}
}

//3.creating decorator

class decarator implements Pizza{
	Pizza pizza;
	public decarator(Pizza pizza) {
		this.pizza = pizza;
	}
	public String getDescription() {
		return pizza.getDescription();
	}
	public double getCost() {
		return pizza.getCost()	;
		
	}
}

//4. now create concreate decarators;
class cheeseToppings extends decarator{
	public cheeseToppings(Pizza pizza) {
		super(pizza);
	}
	
	public String getDescription() {
		return pizza.getDescription() + " cheese ";
	}
	public double getCost() {
		return pizza.getCost()+20.0;
	}
	
}

class oliveToppings extends decarator{
	public oliveToppings(Pizza pizza) {
		super(pizza);
	}
	public String getDescription() {
		return pizza.getDescription()+ " Olive ";
	}
	public double getCost() {
		return pizza.getCost()+10.0;
	}
	
}


public class DecoratorPattern {
	public static void main(String args[]) {
		 Pizza pizza = new MargaritaPizza();
		 System.out.println(pizza.getDescription()+" -> Rs. "+ pizza.getCost());
		 pizza = new cheeseToppings(pizza);
		 System.out.println(pizza.getDescription()+" ->Rs. "+ pizza.getCost());
		 pizza = new oliveToppings(pizza);
		 System.out.println(pizza.getDescription()+" ->Rs. "+ pizza.getCost());
		 
	}

}

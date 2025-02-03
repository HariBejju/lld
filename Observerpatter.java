package com.mphasisJava.MyDemoProject;

import java.util.ArrayList;
import java.util.List;

// 1.create observer 
interface observer{
	void update(String msg);
}

//observer interface reflects the changes on the observer side (users) like notification
//2. create subject
// observer handles the changes happening to the observers
// subject handles the observers
interface subject{
	void addObserver(observer ob);
	void removeObserver(observer ob);
	void notifyObserver();
}

//3. create concreate subject( the one that creates obj for subject blueprint)

class Forum implements subject{
	
	List<observer>Obs = new ArrayList<>();
	String msg;
	public void addObserver(observer ob) {
		Obs.add(ob);
	}
	public void removeObserver(observer ob) {
		Obs.remove(ob);
	}
	public void notifyObserver() {
		for(observer ob:Obs) {
			ob.update(msg);
		}
	}
	public void newMsg(String msg) {
		this.msg = msg;
		System.out.println(" New post added: "+msg);
		notifyObserver();
	}
}

//4. create concreate Observer

class Employee implements observer{
	String name;
	public Employee(String name) {
		this.name = name;
	}
	public void update(String msg) {
		System.out.println(name+" received an update: "+msg);
	}
}

public class Observerpattern {
	public static void main(String args[]) {
		// creating forum 
		Forum forum = new Forum();
		// creating employees
		Employee e1 = new Employee("John");
		Employee e2 = new Employee("bob");
		Employee e3 = new Employee("Alice");
		
		forum.addObserver(e1);
		forum.addObserver(e2);
		forum.addObserver(e3);
		
		forum.newMsg(" we have a meet here now guys. Get in the meet");
		
		
	}

}

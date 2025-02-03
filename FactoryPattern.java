package com.mphasisJava.MyDemoProject;

import java.util.Scanner;

interface document{
	void create();
}

class pdfdoc implements document{
	public void create() {
		System.out.println(" PDF document is created");
	}
}

class worddoc implements document{
	public void create() {
		System.out.println(" Word document is created");
	}
}


class DocFactory {
	public void create(String req) {
		if(req.equals("PDF")) {
			pdfdoc p1 = new pdfdoc();
			p1.create();
		}
		if(req.equals("Word")) {
			pdfdoc p1 = new pdfdoc();
			p1.create();
		}
	}
}



public class Factory {
	public static void main(String args[]) {
		System.out.println("Enter the choice PDF or Word");
		String t1;
		Scanner sc = new Scanner(System.in);
		t1=sc.nextLine();
		DocFactory d1 = new DocFactory();
		d1.create(t1);
		
	}
}

// let me explain with example, in factory method there is always a factory main class that gets input from the user on what he needs. Say the user wants pdf or word, the input is scanned from the user
// The factory class calls the object that will create the particular document. here document will be a interface
//The Factory Design Pattern is a way to create objects (like PDF or Word documents) without specifying the exact class that will be created.
//Instead, we use a factory to handle the decision-making process. It’s like a factory that makes different products, but you don’t know which one you’ll get until you ask.

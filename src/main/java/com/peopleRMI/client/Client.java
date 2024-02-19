package com.peopleRMI.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import com.peopleRMI.PeopleService;
import com.peopleRMI.bo.Person;

public class Client {
	// Host or IP of Server
	private static final String HOST = "localhost";
	private static final int PORT = 1099;
	private static Registry registry;
	
	public static void main(String[] args) throws Exception {
		registry = LocateRegistry.getRegistry(HOST, PORT);
		
		PeopleService service = 
				(PeopleService) registry
				.lookup(PeopleService.class.getSimpleName());
		
		List<Person> people = service.getAllPeople();
		
		if (people.size() > 0) {			
			printPeopleToConsole(people);			
		} else {

			service.insertPerson("alex");
			service.insertPerson("fred");
			service.insertPerson("tom");
			service.insertPerson("poop");
	    	
	    	people = service.getAllPeople();
	    	
	    	printPeopleToConsole(people);
		}
	}

	private static void printPeopleToConsole(List<Person> people) {
		for (Person person : people) {
			System.out.println(person.toString());
		}
	}

}

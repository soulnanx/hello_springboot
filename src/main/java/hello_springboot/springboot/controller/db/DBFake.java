package hello_springboot.springboot.controller.db;

import java.util.ArrayList;
import java.util.List;

import hello_springboot.springboot.entity.Person;


public class DBFake {
	
	private static List<Person> people;
	
	public static void save(Person person){
		if (people == null){
			people = new ArrayList<Person>();
		}
		
		people.add(person);
	}
	
	public static Person findByName(String name){
		for (Person person : people){
			if (person.getName().equals(name)){
				return person;
			}
		}
		
		return null;
	}
	
	public static List<Person> getAll(){
		return people;
	}

}

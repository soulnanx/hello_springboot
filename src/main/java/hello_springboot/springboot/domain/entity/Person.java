package hello_springboot.springboot.domain.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person {
	
	@Id
	private ObjectId idPerson;
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ObjectId getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(ObjectId idPerson) {
		this.idPerson = idPerson;
	}

}

package hello_springboot.springboot.repository;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.Mongo;

import hello_springboot.springboot.entity.Person;

@Repository
public class PersonRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(Person person){
		try {
			mongoTemplate = new MongoTemplate(new Mongo("192.168.99.100", 27017), "teste");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mongoTemplate.save(person);
	}
	
	public List<Person> findAll(){
		try {
			mongoTemplate = new MongoTemplate(new Mongo("192.168.99.100", 27017), "teste");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mongoTemplate.findAll(Person.class);
	}
}

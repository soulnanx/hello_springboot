package hello_springboot.springboot.repository;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Repository;

import com.mongodb.Mongo;
import com.mongodb.MongoClientURI;

import hello_springboot.springboot.entity.Person;

@Repository
public class PersonRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public PersonRepository() {
		MongoClientURI uri = new MongoClientURI("mongodb://192.168.99.100:27017/teste");

		try {
			mongoTemplate = new MongoTemplate(new SimpleMongoDbFactory(uri));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void save(Person person) {
		mongoTemplate.save(person);
	}

	public List<Person> findAll() {
		return mongoTemplate.findAll(Person.class);
	}
}

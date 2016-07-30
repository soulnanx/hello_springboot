package hello_springboot.springboot.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import hello_springboot.springboot.domain.entity.Person;

@Repository
public class PersonRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void save(Person person) {
		mongoTemplate.save(person);
	}

	public List<Person> findAll() {
		return mongoTemplate.findAll(Person.class);
	}
}

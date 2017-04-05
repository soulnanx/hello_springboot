package hello_springboot.springboot.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import hello_springboot.springboot.entity.Institution;
import hello_springboot.springboot.parse.client.ParseClient;

@Repository
public class InstitutionRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void save(Institution institution) {
		mongoTemplate.save(institution);
	}

	public List<Institution> findAll() {
		return new ParseClient().getInstitutions();
	}
}

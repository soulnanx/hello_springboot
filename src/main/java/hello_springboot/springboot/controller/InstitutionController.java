package hello_springboot.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello_springboot.springboot.domain.entity.Person;
import hello_springboot.springboot.domain.repository.InstitutionRepository;
import hello_springboot.springboot.entity.Institution;


@RestController
@RequestMapping("/institution")
public class InstitutionController {
	
	@Autowired
	private InstitutionRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	List<Institution> index() {
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	String person(@RequestBody Person person) {
		//repository.save(person);
		return person.getName();
	}

}

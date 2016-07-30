package hello_springboot.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello_springboot.springboot.entity.Person;
import hello_springboot.springboot.repository.PersonRepository;


@RestController
public class PersonController {

	@RequestMapping(method = RequestMethod.GET, value = "/person")
	@ResponseBody
	List<Person> index() {
		return new PersonRepository().findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/person")
	@ResponseBody
	String person(@RequestBody Person person) {
		new PersonRepository().save(person);
		return person.getName();
	}

}

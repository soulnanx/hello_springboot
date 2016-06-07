package hello_springboot.springboot.controller;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello_springboot.springboot.controller.db.DBFake;
import hello_springboot.springboot.entity.Person;


@RestController
public class PersonController {

	@RequestMapping(method = RequestMethod.GET, value = "/person/{name}")
	@ResponseBody
	ResponseEntity<Person> find(@PathVariable String name) {
		Person person = DBFake.findByName(name);
		
		if (person == null) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(person);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/person")
	@ResponseBody
	List<Person> index() {
		return DBFake.getAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/person")
	@ResponseBody
	String person(@RequestBody Person person) {
		//DBFake.save(person);
		return person.getName();
	}

}

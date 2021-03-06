package com.harlandclarke.bootdemo.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harlandclarke.bootdemo.entity.Person;
import com.harlandclarke.bootdemo.entity.PersonRepository;
/**
 *
 * @author root
 */
@Component("personService")
public class PersonService {


    @Autowired // This means to get the bean called personRepository Which is auto-generated by Spring, we will use it to handle the data
    private PersonRepository personRepository;

    private final Logger logger = LoggerFactory.getLogger(PersonService.class);

    public String format(){
        return "You saved it!";
    }

    public boolean OnboardPerson(Person person) {
        Person n = new Person();
        n.setFirstName(person.getFirstName());
        n.setEmail(person.getEmail());
        n.setAccountNumber(person.getAccountNumber());
        n.setLastName(person.getLastName());
        n.setLoginID(person.getLoginID());
        n.setPhone(person.getPhone());
        n.setRoutingNumber(person.getRoutingNumber());
        personRepository.save(n);
        logger.debug("--saving person in person service--");
        return true;
    }

    public Person getThisUser(Integer token) {
        return personRepository.findByPersonIndex(token);
    }



    public Iterable<Person> getAllUsers() {
        return personRepository.findAll();
    }


}
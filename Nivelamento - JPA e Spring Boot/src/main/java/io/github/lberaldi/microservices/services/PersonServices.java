package io.github.lberaldi.microservices.services;

import io.github.lberaldi.microservices.exceptions.ResourceNotFoundException;
import io.github.lberaldi.microservices.model.Person;
import io.github.lberaldi.microservices.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){
        logger.info("Finding all person!");
        return personRepository.findAll();
    }

    public Person create(Person person){
        logger.info("Creating one person!");

        return personRepository.save(person);
    }

    public Person update(Person person){
        logger.info("updating one person!");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Id não encontrado!!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
    }

    public void delete(Long id){
        logger.info("deleting one person!");

        Person entity = personRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Id não encontrado!!"));

        personRepository.delete(entity);

    }

    public Person findById(Long id) {

        logger.info("Finding one person!");

        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!!"));
    }
}

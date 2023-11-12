package com.limq.marker.resource;

import com.limq.api.PersonApi;
import com.limq.model.Person;
import com.limq.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@Component
public class PersonController implements PersonApi {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public ResponseEntity<Person> create(Person person) {
        return ok(personRepository.save(person));
    }

    @Override
    public ResponseEntity read(UUID id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()){
            return ok(person.get());
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity update(UUID id, Person updatedPerson) {
        Optional<Person> currentPerson = personRepository.findById(id);
        if (currentPerson.isPresent()){
            return ok(personRepository.save(updatedPerson));
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity delete(UUID id) {
        Optional<Person> currentPerson = personRepository.findById(id);
        if (currentPerson.isPresent()){
            personRepository.delete(currentPerson.get());
            return noContent().build();
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity<Collection<Person>> list() {
        return ResponseEntity.ok(personRepository.findAll());
    }
}

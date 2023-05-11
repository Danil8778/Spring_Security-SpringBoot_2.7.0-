package com.pnevsky.spring_security.services;

import com.pnevsky.spring_security.models.Person;
import com.pnevsky.spring_security.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrationService {

    PersonRepository personRepository;

    @Autowired
    public RegistrationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void register(Person person){
        personRepository.save(person);
    }

}

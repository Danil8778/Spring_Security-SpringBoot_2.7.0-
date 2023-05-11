package com.pnevsky.spring_security.util;

import com.pnevsky.spring_security.models.Person;
import com.pnevsky.spring_security.repositories.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private PersonRepository personRepository;

    public PersonValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person =(Person) target;

        if(!personRepository.findByUsername(person.getUsername()).isEmpty())
            errors.rejectValue("username","","A person with that name already exist");
    }
}

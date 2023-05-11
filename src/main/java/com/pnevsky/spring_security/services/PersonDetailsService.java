package com.pnevsky.spring_security.services;

import com.pnevsky.spring_security.models.Person;
import com.pnevsky.spring_security.repositories.PersonRepository;
import com.pnevsky.spring_security.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Person> person = personRepository.findByUsername(username);

       if (person.isEmpty())
           throw new UsernameNotFoundException("A person is not found");

       return new PersonDetails(person.get());
    }
}

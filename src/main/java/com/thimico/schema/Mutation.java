package com.thimico.schema;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thimico.entities.Person;
import com.thimico.exception.PersonNotFoundException;
import com.thimico.dto.CreatePersonDto;
import com.thimico.dto.SetPartnerDto;
import com.thimico.repository.PersonRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */
@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Person createPerson(CreatePersonDto inputPerson) {
        Person aPerson = new Person();
        aPerson.setName(inputPerson.getName());
        aPerson.setAge(inputPerson.getAge());
        aPerson.setChildrenNames(inputPerson.getChildrenNames());
        return this.personRepository.save(aPerson);
    }

    @Transactional
    public Person setPartner(SetPartnerDto inputPartner) {
        Person person = getPersonById(inputPartner.getId());

        Person partner = new Person();
        partner.setName(inputPartner.getName());
        partner.setAge(inputPartner.getAge());
        partner.addChildrenNames(inputPartner.getChildrenNames());

        person.setPartner(partner);
        this.personRepository.save(partner);
        return this.personRepository.save(person);

    }

    @Transactional
    public boolean deletePerson(Long id) {
        return personRepository.deletePersonById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @NotNull
    private Person getPersonById(Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));
    }

}

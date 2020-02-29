package com.thimico.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thimico.entities.Person;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Set;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */
@Component
public class Mutation implements GraphQLMutationResolver {

    @Transactional
    public Person createPerson(String name, Set<String> childrenNames, Integer age) {
        Person aPerson = new Person();
        aPerson.setId(2l);
        aPerson.setName(name);
        aPerson.setAge(age);
        aPerson.setChildrenNames(childrenNames);
        return aPerson;
    }

    @Transactional
    public Person setPartner(Long id, Long partnerID) {
        Person partner = new Person();
        partner.setId(partnerID);
        partner.setName("Father");

        Person aPerson = new Person();
        aPerson.setId(2l);
        aPerson.setName("Bill");
        aPerson.setAge(9);
        aPerson.setPartner(partner);
        return aPerson;

    }

    @Transactional
    public boolean deleteTour(Long id) {
        return true;

    }

}

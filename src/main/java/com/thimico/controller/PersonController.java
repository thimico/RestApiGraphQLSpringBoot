package com.thimico.controller;


import com.thimico.dto.ResponseDto;
import com.thimico.entities.Person;
import com.thimico.dto.CreatePersonDto;
import com.thimico.dto.SetPartnerDto;
import com.thimico.schema.Mutation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.thimico.resolvers.Query;

import java.util.List;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */
@Slf4j
@RestController
@RequestMapping("api/rest/person")
public class PersonController {
    @Autowired
    private Query query;

    @Autowired
    private Mutation mutation;



    @GetMapping
    @ResponseBody
    public List<Person> get() {
        log.debug("Query Persons");
        return query.getAllPersons();
    }



    @GetMapping(value = "{id}")
    @ResponseBody
    public Person get(@PathVariable("id") Long id) {
        log.debug("Searching Person by id {}", id);
        return query.getPerson(id);
    }



    @PostMapping
    @ResponseBody
    public void personCreate(@RequestBody CreatePersonDto personInput) {
        mutation.createPerson(personInput);
    }



    @PatchMapping
    @ResponseBody
    public Person partnerSet(@RequestBody SetPartnerDto personInput) {
        return mutation.setPartner(personInput);
    }



    @DeleteMapping("{id}")
    public ResponseDto personDelete(@PathVariable Long lotid) {
        log.debug("Delete Person by id {}", lotid);
        mutation.deletePerson(lotid);
        return new ResponseDto(true, "message.backend.success.default.deleted");
    }
}

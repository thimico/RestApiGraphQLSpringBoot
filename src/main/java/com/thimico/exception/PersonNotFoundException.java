package com.thimico.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */
public class PersonNotFoundException extends RuntimeException implements GraphQLError {

    private Long personId;


    private Map<String, Object> extensions = new HashMap<>();



    public PersonNotFoundException(String message, Long personId) {
        super(message);
        extensions.put("personId", personId);
    }



    public PersonNotFoundException(Long tourId) {
        this.personId = tourId;
    }



    @Override
    public String getMessage() {
        return "Person with ID " + personId + " could not be found";
    }



    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }



    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("personId", personId);
    }



    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
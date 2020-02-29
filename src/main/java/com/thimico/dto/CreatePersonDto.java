package com.thimico.dto;

import lombok.*;

import java.util.Set;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */
@Data
public class CreatePersonDto {

    private String name;

    private Set<String> childrenNames;

    private int age;

}

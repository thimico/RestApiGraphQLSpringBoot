package com.thimico.input;

import lombok.*;

import java.util.Set;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */
@Data
public class CreatePersonInput {

    private String name;

    private Set<String> childrenNames;

    private int age;

}

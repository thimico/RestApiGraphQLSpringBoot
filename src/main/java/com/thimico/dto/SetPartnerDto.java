package com.thimico.dto;

import lombok.Data;

import java.util.Set;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */
@Data
public class SetPartnerDto {

    private Long id;

    private String name;

    private Set<String> childrenNames;

    private int age;

}

package com.thimico.entities;

import lombok.Data;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import javax.persistence.*;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */
@Data
@Table(name = "person")
@Entity
public class Person {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Transient
    private Set<String> childrenNames;

    private int age;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Person partner;

    public Set<String> getChildrenNames() {
        return childrenNames == null ? Collections.emptySet() : childrenNames;
    }

    public void addChildrenNames(Set<String> names) {
        for (String name : names) {
            addChildrenName(name);
        }
    }

    public void addChildrenName(String name) {
        if (childrenNames == null) {
            childrenNames = new HashSet<>();
        }
        childrenNames.add(name);
    }

}
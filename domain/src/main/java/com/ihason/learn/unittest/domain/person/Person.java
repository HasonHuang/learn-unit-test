package com.ihason.learn.unittest.domain.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.isTrue;

@Getter
@Setter
@ToString
@Entity
public class Person {

    /**
     * ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    public static Person from(String name, int age) {
        hasText(name, "The name cannot be blank");
        isTrue(0 < age && age <= 120, "The age must be between 1 and 120");
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }

}

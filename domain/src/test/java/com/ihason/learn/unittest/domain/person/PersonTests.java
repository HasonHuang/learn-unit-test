package com.ihason.learn.unittest.domain.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTests {

    @Test
    @DisplayName("创建对象")
    public void should_generate_person() {
        String name = "ab";
        int age = 10;
        Person person = Person.from(name, age);
        assertThat(person).isNotNull();
        assertThat(person.getName()).isEqualTo(name);
    }

}

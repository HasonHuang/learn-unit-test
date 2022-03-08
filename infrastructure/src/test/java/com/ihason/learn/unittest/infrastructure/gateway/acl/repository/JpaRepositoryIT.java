package com.ihason.learn.unittest.infrastructure.gateway.acl.repository;

import com.ihason.learn.unittest.domain.person.Person;
import com.ihason.learn.unittest.domain.person.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 基于 H2 内存数据库的仓储接口测试用例
 *
 * @author Hason
 */
@DataJpaTest
@EnableJpaRepositories(basePackageClasses = PersonRepository.class)
@EntityScan(basePackageClasses = Person.class)
public class JpaRepositoryIT {

    @Autowired
    private PersonRepository repository;

    @Commit
    @Test
    @DisplayName("保存入库")
    public void save_one() {
        Person person = Person.from("ab", 12);
        repository.save(person);
        assertThat(person.getId()).isNotNull();
    }

    @Test
    @DisplayName("查询数据")
    public void list_all() {
        List<Person> persons = repository.findAll();
        assertThat(persons).isNotEmpty();
    }

}

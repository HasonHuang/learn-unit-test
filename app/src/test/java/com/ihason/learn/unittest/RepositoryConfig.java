package com.ihason.learn.unittest;

import com.ihason.learn.unittest.domain.person.Person;
import com.ihason.learn.unittest.domain.person.PersonRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 扫描 JPA 组件
 *
 * @author Hason
 */
@TestConfiguration
@EnableJpaRepositories(basePackageClasses = PersonRepository.class)
@EntityScan(basePackageClasses = Person.class)
public class RepositoryConfig {
}

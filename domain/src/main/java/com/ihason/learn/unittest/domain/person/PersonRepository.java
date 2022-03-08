package com.ihason.learn.unittest.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Person 仓储接口
 *
 * @author Hason
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}

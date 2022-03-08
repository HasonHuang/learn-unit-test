package com.ihason.learn.unittest.app.service;

import com.ihason.learn.unittest.RepositoryConfig;
import com.ihason.learn.unittest.app.dto.request.CreatePersonRequest;
import com.ihason.learn.unittest.app.dto.response.PersonDTO;
import com.ihason.learn.unittest.domain.person.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 使用 Spring Test 进行集成测试
 *
 * @author Hason
 */
@DataJpaTest
@ContextConfiguration(classes = { PersonAppService.class, PersonService.class, RepositoryConfig.class })
public class CreatePersonAppServiceTests {

    @Autowired
    private PersonAppService service;

    @Test
    @DisplayName("保存对象")
    public void should_create_person() {
        // given
        CreatePersonRequest request = new CreatePersonRequest();
        request.setName("Tom");
        // when
        PersonDTO dto = service.create(request);
        // then
        assertThat(dto.getId()).isNotNull();
    }

}

package com.ihason.learn.unittest.app.service;

import com.ihason.learn.unittest.RepositoryConfig;
import com.ihason.learn.unittest.app.dto.response.PersonDTO;
import com.ihason.learn.unittest.domain.person.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 查询用例的集成测试
 *
 * @author Hason
 */
@DataJpaTest
@ContextConfiguration(classes = { PersonAppService.class, RepositoryConfig.class })
public class ListPersonAppServiceTests {

    @Autowired
    private PersonAppService service;

    @MockBean
    private PersonService domainService;

    @Test
    @DisplayName("查询对象列表")
    @Sql(scripts = "classpath:db/data.sql")
    public void should_list_person() {
        // when
        List<PersonDTO> dtos = service.listAll();
        // then
        assertThat(dtos).isNotEmpty();
    }

    @Test
    @DisplayName("查询指定对象")
    @Sql(scripts = "classpath:db/data.sql")
    public void should_get_person() {
        // given
        Long id = 1L;
        // when
        PersonDTO dto = service.get(id);
        // then
        assertThat(dto).isNotNull();
    }

}

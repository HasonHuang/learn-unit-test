package com.ihason.learn.unittest.app.service;

import com.ihason.learn.unittest.domain.person.PersonRepository;
import com.ihason.learn.unittest.domain.person.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = PersonAppService.class)
public class ListPersonAppServiceTests {

    @Autowired
    private PersonAppService service;

    @MockBean
    private PersonService domainService;

    @MockBean
    private PersonRepository personRepository;

    @Test
    @DisplayName("查询对象列表")
    public void should_list_person() {
        // when
        service.listAll();
        // then
        verify(personRepository).findAll();
    }

    @Test
    @DisplayName("查询指定对象")
    public void should_get_person() {
        // given
        Long id = 1L;
        // when
        service.get(id);
        // then
        verify(personRepository).findById(eq(id));
    }

}

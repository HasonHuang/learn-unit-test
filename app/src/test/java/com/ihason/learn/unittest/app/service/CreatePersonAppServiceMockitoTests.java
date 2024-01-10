package com.ihason.learn.unittest.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ihason.learn.unittest.app.dto.request.CreatePersonRequest;
import com.ihason.learn.unittest.app.dto.response.PersonDTO;
import com.ihason.learn.unittest.domain.person.Person;
import com.ihason.learn.unittest.domain.person.PersonService;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * 使用 Mockito 套件进行单元测试
 *
 * @author Hason
 */
@ExtendWith(MockitoExtension.class)
public class CreatePersonAppServiceMockitoTests {

    @InjectMocks
    private PersonAppService service;

    @Mock
    private PersonService domainService;

    @Test
    @DisplayName("给定合法名字-当创建用户-那么成功创建")
    public void should_created_when_create_given_nameAndDefaultAge() throws JsonProcessingException, JSONException {
        // given
        CreatePersonRequest request = new CreatePersonRequest();
        request.setName("Tom");

        Person person = Person.from(request.getName(), 100);
        given(domainService.create(eq(request.getName()), anyInt())).willReturn(person);

        // when
        PersonDTO dto = service.create(request);

        // then
        verify(domainService).create(eq(request.getName()), ArgumentMatchers.intThat(i -> i > 0));
        String json = JsonMapper.builder().build().writeValueAsString(dto);
        JSONAssert.assertEquals("{id: null, age: 100, name:'Tom'}", json, true);
    }

}

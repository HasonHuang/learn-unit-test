package com.ihason.learn.unittest.infrastructure.ohs.resource;

import com.ihason.learn.unittest.app.dto.request.CreatePersonRequest;
import com.ihason.learn.unittest.app.dto.response.PersonDTO;
import com.ihason.learn.unittest.app.service.PersonAppService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
public class PersonControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonAppService service;

    @Test
    @DisplayName("校验缺少参数400")
    public void should_valid_argument() throws Exception {
        // given
        PersonDTO dto = new PersonDTO();
        CreatePersonRequest request = new CreatePersonRequest();
        given(service.create(request)).willReturn(dto);
        // when
        mvc.perform(
                post("/persons")
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("创建对象")
    public void should_create_success() throws Exception {
        // given
        Long id = 1L;
        PersonDTO dto = new PersonDTO();
        CreatePersonRequest request = new CreatePersonRequest();
        given(service.create(request)).willReturn(dto);
        // when
        mvc.perform(
                post("/persons")
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Tester\"}")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}

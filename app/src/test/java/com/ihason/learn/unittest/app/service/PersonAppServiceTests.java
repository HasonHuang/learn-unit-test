package com.ihason.learn.unittest.app.service;

import com.ihason.learn.unittest.app.dto.request.CreatePersonRequest;
import com.ihason.learn.unittest.app.dto.response.PersonDTO;
import com.ihason.learn.unittest.domain.person.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PersonAppServiceTests {

    @InjectMocks
    private PersonAppService service;

    @Mock
    private PersonService domainService;

    @Test
    @DisplayName("保存对象")
    public void should_create_person() {
        // given
        CreatePersonRequest request = new CreatePersonRequest();
        request.setName("Tom");
        // when
        PersonDTO dto = service.create(request);
        // then
        verify(domainService).create(eq(request.getName()), ArgumentMatchers.intThat(i -> i > 0));
    }

}

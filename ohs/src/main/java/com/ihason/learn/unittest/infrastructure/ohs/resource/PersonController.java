package com.ihason.learn.unittest.infrastructure.ohs.resource;

import com.ihason.learn.unittest.app.dto.request.CreatePersonRequest;
import com.ihason.learn.unittest.app.dto.response.PersonDTO;
import com.ihason.learn.unittest.app.service.PersonAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonAppService service;

    @GetMapping("")
    public Collection<PersonDTO> list() {
        return service.listAll();
    }

    @PostMapping("")
    public PersonDTO create(@Valid @RequestBody CreatePersonRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public PersonDTO get(@PathVariable Long id) {
        return service.get(id);
    }

}

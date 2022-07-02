package ru.logstream.creditapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.logstream.creditapp.json.UserJson;
import ru.logstream.creditapp.json.converters.UserJsonConverter;
import ru.logstream.creditapp.models.beans.UserBean;
import ru.logstream.creditapp.models.validation.Create;
import ru.logstream.creditapp.models.validation.Update;
import ru.logstream.creditapp.services.UserRepositoryService;

@RestController
@RequestMapping("credit-app/users")
public class UserController {
    private UserRepositoryService service;

    private UserJsonConverter converter;

    @Autowired
    public void setService(UserRepositoryService service) {
        this.service = service;
    }

    @Autowired
    public void setConverter(UserJsonConverter converter) {
        this.converter = converter;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserBean save(@RequestBody @Validated(Create.class) UserJson user) {
        return service.save(converter.toBean(user));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserBean getById(@PathVariable(name = "id") Long id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserBean update(@RequestBody @Validated(Update.class) UserJson user) {
        return service.update(converter.toBean(user));
    }
}

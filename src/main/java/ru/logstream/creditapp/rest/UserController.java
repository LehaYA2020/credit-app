package ru.logstream.creditapp.rest;

import org.springframework.web.bind.annotation.*;
import ru.logstream.creditapp.models.beans.UserBean;
import ru.logstream.creditapp.services.UserRepositoryService;

@RestController
@RequestMapping("credit-app/users")
public class UserController {
    private UserRepositoryService service;
    @PostMapping
    public UserBean save(@RequestBody UserBean user) {
        return service.save(user);
    }

    @GetMapping("/{id}")
    public UserBean getById(@PathVariable(name = "id") Long id) {
        return service.getById(id);
    }

    @PutMapping
    public UserBean update(@RequestBody UserBean user) {
        return service.update(user);
    }
}

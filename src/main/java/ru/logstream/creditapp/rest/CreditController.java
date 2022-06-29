package ru.logstream.creditapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.logstream.creditapp.models.beans.CreditBean;
import ru.logstream.creditapp.models.validation.Create;
import ru.logstream.creditapp.models.validation.Update;
import ru.logstream.creditapp.services.CreditRepositoryService;

import java.util.List;

@RestController
@RequestMapping("credit-app/credits")
public class CreditController {
    private CreditRepositoryService service;

    @Autowired
    public void setCreditRepositoryService(CreditRepositoryService repository) {
        this.service = repository;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreditBean save(@RequestBody @Validated(Create.class) CreditBean credit) {
        return service.save(credit);
    }

    @PutMapping
    public CreditBean update(@RequestBody @Validated(Update.class) CreditBean credit) {
        return service.update(credit);
    }
}

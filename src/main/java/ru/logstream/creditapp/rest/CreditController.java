package ru.logstream.creditapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.logstream.creditapp.models.beans.CreditBean;
import ru.logstream.creditapp.services.CreditRepositoryService;

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
    public CreditBean save(@RequestBody CreditBean credit) {
        return service.save(credit);
    }

    @GetMapping("/{userId}")
    public Boolean haveCreditHistory(@PathVariable(name = "userId") Long userId){
        return service.haveCreditHistory(userId);
    }
}

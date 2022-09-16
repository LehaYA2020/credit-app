package ru.logstream.creditapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.logstream.creditapp.json.CreditJson;
import ru.logstream.creditapp.json.converters.CreditJsonConverter;
import ru.logstream.creditapp.models.beans.CreditBean;
import ru.logstream.creditapp.models.validation.Create;
import ru.logstream.creditapp.models.validation.Update;
import ru.logstream.creditapp.services.CreditRepositoryService;

@RestController
@RequestMapping("credit-app/credits")
public class CreditController {
    private CreditRepositoryService service;
    private CreditJsonConverter converter;

    @Autowired
    public void setConverter(CreditJsonConverter converter) {
        this.converter = converter;
    }

    @Autowired
    public void setCreditRepositoryService(CreditRepositoryService service) {
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreditBean save(@RequestBody @Validated(Create.class) CreditJson credit) {
        return service.save(converter.toBean(credit));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CreditBean update(@RequestBody @Validated(Update.class) CreditJson credit) {
        return service.update(converter.toBean(credit));
    }
}

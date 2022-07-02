package ru.logstream.creditapp.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.logstream.creditapp.exceptions.UserNotFoundException;
import ru.logstream.creditapp.json.UserJson;
import ru.logstream.creditapp.json.converters.UserJsonConverter;
import ru.logstream.creditapp.models.beans.UserBean;
import ru.logstream.creditapp.services.UserRepositoryService;

import java.util.Optional;

@Component
public class UserRepositoryServiceDelegate implements JavaDelegate {
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

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

    }
    public Boolean existsById(Long id) {
        return service.existsById(id);
    }

    public UserJson getById(Long id) {
        UserJson user= converter.toJson(service.getById(id));
        return user;
    }
}

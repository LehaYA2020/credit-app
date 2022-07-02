package ru.logstream.creditapp.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.logstream.creditapp.services.CreditRepositoryService;

@Component
public class CreditRepositoryServiceDelegate implements JavaDelegate {
    @Autowired
    private CreditRepositoryService service;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

    }

    public boolean haveCreditHistory(Long userId) {
        return service.haveCreditHistory(userId);
    }
}

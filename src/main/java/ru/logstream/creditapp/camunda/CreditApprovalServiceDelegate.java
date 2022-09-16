package ru.logstream.creditapp.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.logstream.creditapp.json.CreditJson;
import ru.logstream.creditapp.json.converters.CreditJsonConverter;
import ru.logstream.creditapp.services.CreditApprovalService;

@Component
public class CreditApprovalServiceDelegate implements JavaDelegate {
    private CreditJsonConverter converter;
    private CreditApprovalService service;

    @Autowired
    public void setConverter(CreditJsonConverter converter) {
        this.converter = converter;
    }

    @Autowired
    public void setService(CreditApprovalService service) {
        this.service = service;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

    }

    public boolean approve(CreditJson credit) {
        return service.approve(converter.toBean(credit));
    }
}

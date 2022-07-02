package ru.logstream.creditapp.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.logstream.creditapp.json.CreditJson;
import ru.logstream.creditapp.json.converters.CreditJsonConverter;
import ru.logstream.creditapp.models.beans.CreditBean;
import ru.logstream.creditapp.services.CreditApprovalService;

@Component
public class ApproveCreditProcess implements JavaDelegate {
    @Autowired
    private CreditJsonConverter converter;
    private CreditApprovalService service;

    @Autowired
    public void setService(CreditApprovalService service) {
        this.service = service;
    }

    Integer amount;
    Long userId;
    Integer percent;
    Integer term;
    @Override
    public void execute(DelegateExecution delegateExecution) {
        amount = (Integer) delegateExecution.getVariable("amount");
        userId = (Long) delegateExecution.getVariable("userId");
        percent = (Integer) delegateExecution.getVariable("percent");
        term = (Integer) delegateExecution.getVariable("term");
    }
    public CreditJson getCreditBean() {
        return CreditJson.builder()
                .amount(amount)
                .userId(userId)
                .percent(percent)
                .term(term)
                .build();
    }
}

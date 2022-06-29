package ru.logstream.creditapp.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.logstream.creditapp.models.beans.CreditBean;
import ru.logstream.creditapp.services.CreditApprovalService;

@Component
public class ApproveCreditProcess implements JavaDelegate {
    private CreditApprovalService service;

    @Autowired
    public void setService(CreditApprovalService service) {
        this.service = service;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        Integer amount = (Integer) delegateExecution.getVariable("amount");
        Long userId = (Long) delegateExecution.getVariable("userId");
        Integer percent = (Integer) delegateExecution.getVariable("percent");
        Integer term = (Integer) delegateExecution.getVariable("term");
        delegateExecution.setVariable("approved", service.approve(
                        CreditBean.builder()
                                .userId(userId)
                                .amount(amount)
                                .percent(percent)
                                .term(term)
                                .build()
                )
        );
    }
}

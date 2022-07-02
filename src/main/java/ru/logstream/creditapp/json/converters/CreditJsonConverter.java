package ru.logstream.creditapp.json.converters;

import org.springframework.stereotype.Component;
import ru.logstream.creditapp.json.CreditJson;
import ru.logstream.creditapp.models.beans.CreditBean;
import ru.logstream.creditapp.models.entities.CreditEntity;

@Component
public class CreditJsonConverter {
    public CreditBean toBean(CreditJson json) {
        return CreditBean.builder()
                .id(json.getId())
                .userId(json.getUserId())
                .isPaid(json.getIsPaid())
                .percent(json.getPercent())
                .term(json.getTerm())
                .amount(json.getAmount())
                .processingDate(json.getProcessingDate())
                .repaymentDate(json.getRepaymentDate())
                .build();
    }

    public CreditJson toJson(CreditBean bean) {
        return CreditJson.builder()
                .id(bean.getId())
                .userId(bean.getUserId())
                .isPaid(bean.getIsPaid())
                .percent(bean.getPercent())
                .term(bean.getTerm())
                .amount(bean.getAmount())
                .processingDate(bean.getProcessingDate())
                .repaymentDate(bean.getRepaymentDate())
                .build();
    }
}

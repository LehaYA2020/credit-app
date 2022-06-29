package ru.logstream.creditapp.converters;

import org.springframework.stereotype.Component;
import ru.logstream.creditapp.models.beans.CreditBean;
import ru.logstream.creditapp.models.entities.CreditEntity;

@Component
public class CreditConverter {
    public CreditBean toBean(CreditEntity entity) {
        return CreditBean.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .isPaid(entity.getIsPaid())
                .percent(entity.getPercent())
                .term(entity.getTerm())
                .amount(entity.getAmount())
                .processingDate(entity.getProcessingDate())
                .repaymentDate(entity.getRepaymentDate())
                .build();
    }

    public CreditEntity toEntity(CreditBean bean) {
        return CreditEntity.builder()
                .id(bean.getId())
                .userId(bean.getUserId())
                .isPaid(bean.getIsPaid())
                .percent(bean.getPercent())
                .term(bean.getTerm())
                .processingDate(bean.getProcessingDate())
                .repaymentDate(bean.getRepaymentDate())
                .build();
    }
}

package ru.logstream.creditapp.models.beans;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import ru.logstream.creditapp.models.validation.Create;
import ru.logstream.creditapp.models.validation.Update;
import spinjar.com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import spinjar.com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Getter
public class CreditBean {

    @NotNull(groups = Update.class)
    @Null(groups = Create.class)
    private final Long id;
    @NotNull(groups = {Create.class, Update.class})
    private final Long userId;
    @NotNull(groups = Create.class)
    @AssertFalse(groups = Create.class)
    private final Boolean isPaid;

    @NotNull(groups = Create.class)
    private final Integer percent;

    @NotNull(groups = Create.class)
    private final Integer term;
    @NotNull(groups = Create.class)
    private final Integer amount;
    @NotNull(groups = Create.class)
    private final LocalDate processingDate;
    @NotNull(groups = Create.class)
    private final LocalDate repaymentDate;


    private CreditBean(Long id, Long userId, Boolean isPaid, Integer percent, Integer term, Integer amount, LocalDate processingDate, LocalDate repaymentDate) {
        this.id = id;
        this.userId = userId;
        this.isPaid = isPaid;
        this.percent = percent;
        this.term = term;
        this.amount = amount;
        this.processingDate = processingDate;
        this.repaymentDate = repaymentDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Long userId;
        private Boolean isPaid;
        private Integer percent;
        private Integer term;
        private Integer amount;
        private LocalDate processingDate;
        private LocalDate repaymentDate;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder isPaid(Boolean isPaid) {
            this.isPaid = isPaid;
            return this;
        }

        public Builder percent(Integer percent) {
            this.percent = percent;
            return this;
        }

        public Builder term(Integer term) {
            this.term = term;
            return this;
        }

        public Builder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Builder processingDate(LocalDate processingDate) {
            this.processingDate = processingDate;
            return this;
        }

        public Builder repaymentDate(LocalDate repaymentDate) {
            this.repaymentDate = repaymentDate;
            return this;
        }

        private Builder() {

        }

        public CreditBean build() {
            return new CreditBean(id, userId, isPaid, percent, term, amount, processingDate, repaymentDate);
        }
    }
}

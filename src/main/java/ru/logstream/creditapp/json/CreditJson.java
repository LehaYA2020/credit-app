package ru.logstream.creditapp.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.logstream.creditapp.models.validation.Create;
import ru.logstream.creditapp.models.validation.Update;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditJson {
    @NotNull(groups = Update.class)
    @Null(groups = Create.class)
    private Long id;
    @NotNull(groups = {Create.class, Update.class})
    private Long userId;
    @NotNull(groups = Create.class)
    @AssertFalse(groups = Create.class)
    private Boolean isPaid;

    @NotNull(groups = Create.class)
    private Integer percent;

    @NotNull(groups = Create.class)
    private Integer term;
    @NotNull(groups = Create.class)
    private Integer amount;
    @NotNull(groups = Create.class)
    private LocalDate processingDate;
    @NotNull(groups = Create.class)
    private LocalDate repaymentDate;


    private CreditJson(Long id, Long userId, Boolean isPaid, Integer percent, Integer term, Integer amount, LocalDate processingDate, LocalDate repaymentDate) {
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

        public CreditJson build() {
            return new CreditJson(id, userId, isPaid, percent, term, amount, processingDate, repaymentDate);
        }
    }
}

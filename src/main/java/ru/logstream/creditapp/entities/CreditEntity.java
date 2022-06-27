package ru.logstream.creditapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credits")
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "paid")
    private Boolean isPaid;
    @Column(name = "percent")
    private Integer percent;
    @Column(name = "term")
    private Integer term;
    @Column(name = "processing_date")
    private LocalDate processingDate;
    @Column(name = "repayment_date")
    private LocalDate repaymentDate;

    public Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Long userId;
        private Boolean isPaid;
        private Integer percent;
        private Integer term;
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

        public CreditEntity build() {
            return new CreditEntity(id, userId, isPaid, percent, term, processingDate, repaymentDate);
        }
    }
}

package ru.logstream.creditapp.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.logstream.creditapp.models.validation.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserJson {
    @Null(groups = Create.class)
    @NotNull(groups = Update.class)
    private Long id;
    @NotNull(groups = Create.class)
    private String name;
    @NotNull(groups = Create.class)
    private String surname;
    @NotNull(groups = Create.class)
    private LocalDate birthday;
    @NotNull(groups = Create.class)
    private String phoneNumber;
    @NotNull(groups = Create.class)
    private Long income;

    private UserJson(Long id, String name, String surname, LocalDate birthday, String phoneNumber, Long income) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.income = income;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJson that = (UserJson) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(surname, that.surname)
                && Objects.equals(birthday, that.birthday)
                && Objects.equals(phoneNumber, that.phoneNumber)
                && Objects.equals(income, that.income);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, phoneNumber, income);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Long id;
        private String name;
        private String surname;
        private LocalDate birthday;
        private String phoneNumber;
        private Long income;

        private Builder() {

        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder income(Long income) {
            this.income = income;
            return this;
        }

        public UserJson build() {
            return new UserJson(id, name, surname, birthday, phoneNumber, income);
        }
    }
}

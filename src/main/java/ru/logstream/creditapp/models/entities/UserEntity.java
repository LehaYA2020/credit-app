package ru.logstream.creditapp.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "income")
    private Long income;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(birthday, that.birthday) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(income, that.income);
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

        public UserEntity build() {
            return new UserEntity(id, name, surname, birthday, phoneNumber, income);
        }
    }
}

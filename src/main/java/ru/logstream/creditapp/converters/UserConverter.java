package ru.logstream.creditapp.converters;

import org.springframework.stereotype.Component;
import ru.logstream.creditapp.models.beans.UserBean;
import ru.logstream.creditapp.models.entities.UserEntity;

@Component
public class UserConverter {
    public UserBean toBean(UserEntity entity) {
        return UserBean.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .birthday(entity.getBirthday())
                .phoneNumber(entity.getPhoneNumber())
                .income(entity.getIncome())
                .build();
    }

    public UserEntity toEntity(UserBean bean) {
        return UserEntity.builder()
                .id(bean.getId())
                .name(bean.getName())
                .surname(bean.getSurname())
                .birthday(bean.getBirthday())
                .phoneNumber(bean.getPhoneNumber())
                .income(bean.getIncome())
                .build();
    }
}

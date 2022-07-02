package ru.logstream.creditapp.json.converters;

import org.springframework.stereotype.Component;
import ru.logstream.creditapp.json.UserJson;
import ru.logstream.creditapp.models.beans.UserBean;
import ru.logstream.creditapp.models.entities.UserEntity;

@Component
public class UserJsonConverter {
    public UserBean toBean(UserJson json) {
        return UserBean.builder()
                .id(json.getId())
                .name(json.getName())
                .surname(json.getSurname())
                .birthday(json.getBirthday())
                .phoneNumber(json.getPhoneNumber())
                .income(json.getIncome())
                .build();
    }

    public UserJson toJson(UserBean bean) {
        return UserJson.builder()
                .id(bean.getId())
                .name(bean.getName())
                .surname(bean.getSurname())
                .birthday(bean.getBirthday())
                .phoneNumber(bean.getPhoneNumber())
                .income(bean.getIncome())
                .build();
    }
}

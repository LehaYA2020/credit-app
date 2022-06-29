package ru.logstream.creditapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.logstream.creditapp.models.beans.UserBean;
import ru.logstream.creditapp.converters.UserConverter;
import ru.logstream.creditapp.dao.UserRepository;
import ru.logstream.creditapp.exceptions.UserNotFoundException;

import java.util.Optional;

@Service
public class UserRepositoryService {
    private UserRepository repository;
    private UserConverter converter;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUserConverter(UserConverter converter) {
        this.converter = converter;
    }

    public UserBean save(UserBean user) {
        return converter.toBean(repository.save(converter.toEntity(user)));
    }

    public UserBean getById(Long id) {
        Optional<UserBean> user = repository.findById(id).map(converter::toBean);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("user with id = " + id + "not found!");
        }
    }
    public UserBean update(UserBean userBean) {
        if(existsById(userBean.getId())){
            return converter.toBean(repository.save(converter.toEntity(userBean)));
        } else {
            throw new UserNotFoundException("user with id = " + userBean.getId() + "not found!");
        }
    }

    public boolean existsById(Long userId) {
        return repository.existsById(userId);
    }

    public Integer getAge(Long userId) {
        if(existsById(userId)) {
            return repository.getAge(userId);
        } else {
            throw new UserNotFoundException("user with id = " + userId + "not found!");
        }
    }
}

package ru.logstream.creditapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.logstream.creditapp.converters.CreditConverter;
import ru.logstream.creditapp.dao.CreditRepository;
import ru.logstream.creditapp.exceptions.CreditNotFoundException;
import ru.logstream.creditapp.models.beans.CreditBean;

import java.util.List;

@Service
public class CreditRepositoryService {
    private CreditRepository repository;
    private CreditConverter converter;

    @Autowired
    public void setCreditRepositoryService(CreditRepository creditRepository) {
        this.repository = creditRepository;
    }

    @Autowired
    public void setCreditConverter(CreditConverter converter) {
        this.converter = converter;
    }

    public CreditBean save(CreditBean credit) {
        return converter.toBean(repository.save(converter.toEntity(credit)));
    }

    public CreditBean update(CreditBean credit) {
        if (repository.existsById(credit.getId())) {
            return converter.toBean(repository.save(converter.toEntity(credit)));
        } else {
            throw new CreditNotFoundException("Credit with id = " + credit.getId()
                    + "and userId = " + credit.getUserId() + "not found!");
        }
    }

    public List<CreditBean> getCreditEntitiesByUserId(Long userId) {
        return repository.getCreditEntitiesByUserId(userId).stream().map(converter::toBean).toList();
    }

    public boolean haveCreditHistory(Long userId) {
        return repository.existsByUserId(userId);
    }

    public Integer checkUnpaidCredits(Long userId) {
        return repository.countAllByUserIdAndIsPaidFalse(userId);
    }
}

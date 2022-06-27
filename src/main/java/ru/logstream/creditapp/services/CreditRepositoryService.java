package ru.logstream.creditapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.logstream.creditapp.dao.CreditRepository;

@Service
public class CreditRepositoryService {
    private CreditRepository creditRepository;

    @Autowired
    public void setCreditRepositoryService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }
}

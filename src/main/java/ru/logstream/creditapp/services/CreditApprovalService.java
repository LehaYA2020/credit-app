package ru.logstream.creditapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.logstream.creditapp.exceptions.UserNotFoundException;
import ru.logstream.creditapp.models.beans.CreditBean;
import ru.logstream.creditapp.models.beans.UserBean;

@Service
public class CreditApprovalService {
    private CreditRepositoryService creditRepositoryService;

    private UserRepositoryService userRepositoryService;

    @Autowired
    public void setCreditRepositoryService(CreditRepositoryService creditRepositoryService) {
        this.creditRepositoryService = creditRepositoryService;
    }

    @Autowired
    public void setUserRepositoryService(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    public boolean approve(CreditBean credit) {
        if (userRepositoryService.existsById(credit.getUserId())) {
            UserBean user = userRepositoryService.getById(credit.getUserId());
            if (creditRepositoryService.haveCreditHistory(user.getId())) {
                if (checkCreditHistory(user.getId()) && checkSolvency(user, credit)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if(checkSolvency(user, credit)){
                    return true;
                }else return false;
            }
        } else {
            throw new UserNotFoundException("user with id = " + credit.getUserId() + "not found!");
        }
    }

    private boolean checkCreditHistory(Long userId) {
        return creditRepositoryService.checkUnpaidCredits(userId) < 2;
    }

    private boolean checkSolvency(UserBean user, CreditBean credit) {
        return userRepositoryService.getAge(user.getId()) >= 18
                && (user.getIncome() * 0.5 > (((credit.getPercent() / 100) + 1) * credit.getAmount()) / credit.getTerm());
    }
}

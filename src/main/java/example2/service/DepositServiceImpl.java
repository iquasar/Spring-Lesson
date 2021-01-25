package example2.service;

import example2.dao.DepositTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositServiceImpl implements DepositService {

    private Validator validator;
    private DepositTransactionsRepository depositTransactionsRepository;

    @Autowired
    public DepositServiceImpl(Validator validator, DepositTransactionsRepository depositTransactionsRepository) {
        this.validator = validator;
        this.depositTransactionsRepository = depositTransactionsRepository;
    }

    public void deposit(long sum) {
        validator.validate(sum);
        depositTransactionsRepository.save(sum);
    }
}

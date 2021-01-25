package example2.dao;

import org.springframework.stereotype.Repository;


@Repository
public class DepositTransactionsRepositoryImpl implements DepositTransactionsRepository {

    public void save(long sum) {
        System.out.println("Сохранили на счет сумму: " + sum);
    }
}

package example2;

import example2.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CashMachine {

    private DepositService depositService;

    @Autowired
    public CashMachine(DepositService depositService) {
        this.depositService = depositService;
    }

    public void deposit() {
        System.out.println("Введите сумму, которую хотите положить на счет");
        Scanner scanner = new Scanner(System.in);
        long sum = scanner.nextLong();
        try {
            depositService.deposit(sum);
        } catch (Exception e) {
            System.out.println("Ошибка при пополнении " + e.getMessage());
        }
    }
}

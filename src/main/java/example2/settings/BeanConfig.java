package example2.settings;


import example2.CashMachine;
import example2.service.DepositService;
import example2.service.СheaterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("example2")
public class BeanConfig {

    @Bean
    public DepositService getСheaterService(){

        return new СheaterService();
    }

    @Bean
    public CashMachine getCashMachine(DepositService depositService){
        return new CashMachine(depositService);
    }
}

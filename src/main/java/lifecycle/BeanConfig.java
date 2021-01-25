package lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean (initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Lifecycle getLifecycle(){
        return  new Lifecycle();
    }
}

package lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


public class Lifecycle implements InitializingBean, DisposableBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lifecycle.class);


    public Lifecycle() {

    }

    @PostConstruct
    public void postConstruct(){
        LOGGER.info("PostConstruct");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("afterPropertiesSet");
    }

    public void initMethod(){
        LOGGER.info("initMethod");
    }

    @PreDestroy
    public void preDestroy(){
        LOGGER.info("preDestroy");
    }

    @Override
    public void destroy() throws Exception {
        LOGGER.info("destroy");
    }

    public void destroyMethod(){
        LOGGER.info("destroyMethod");
    }
}

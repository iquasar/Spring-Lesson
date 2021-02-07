package springLesson.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class TimeLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeLogAspect.class);

    @Pointcut("@annotation(springLesson.aspects.TimeLog)")
    public void callAtMyAnnotation() { }


    @Around("callAtMyAnnotation()")
    public Object logMethodWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime dateTime = LocalDateTime.now();
        LOGGER.info("Start method: {}", dateTime);
        Object proceed = joinPoint.proceed();
        dateTime = LocalDateTime.now();
        LOGGER.info("Finish method: {}", dateTime);
        return proceed;
    }

    @AfterThrowing("callAtMyAnnotation()")
    public void logMethodWithAnnotationAfterThrowing()
    {
        LocalDateTime dateTime = LocalDateTime.now();
        LOGGER.info("Throwing method: {}", dateTime);
    }

}

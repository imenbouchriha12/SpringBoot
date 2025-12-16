package tn.esprit.spring.tpcafe_imen_bouchriha.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectClass {
    //mrthode nommée Advice

    @Before("execution(* tn.esprit.spring.tpcafe_imen_bouchriha.services..*.*(..))")
    public void logMthodEntry(JoinPoint jp) {
        log.info("MthodEntry" + jp.getSignature().getName());
    }

    @After("execution(* tn.esprit.spring.tpcafe_imen_bouchriha.services..*.*(..))")
    public void longMethdEnd(JoinPoint jp){
        log.info("longMethdEnd" + jp.getSignature().getName());
    }

    @Before("execution(* tn.esprit.spring.tpcafe_imen_bouchriha.services..Client*.affecter*(..))")
    public void longMethdAffect(JoinPoint jp){
        log.info("je suis entrain d'executer une methode d'affectaion nommée "+ jp.getSignature().getName());
    }


    @Around("execution(* tn.esprit.spring.tpcafe_imen_bouchriha.services..*.*(..))")
    public Object profile(ProceedingJoinPoint jp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = jp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;
        log.info("Method execution time: " + elapsedTime + " ms");
        return obj;
    }
}

package tn.esprit.spring.tpcafe_imen_bouchriha.schedular;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.spring.tpcafe_imen_bouchriha.entities.Client;
import tn.esprit.spring.tpcafe_imen_bouchriha.repositories.ClientRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class ScheduledMethods {
    private ClientRepository clientRepository;

   /* @Scheduled(fixedRate = 2000)
    public void method1(){
        log.info("Vous pouver prendre pause");
    }

    @Scheduled(fixedDelay = 2000)
    public void method2(){
        log.info("IMEN");
    }*/



}

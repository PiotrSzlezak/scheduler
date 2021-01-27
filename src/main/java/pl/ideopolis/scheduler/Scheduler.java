package pl.ideopolis.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private RestController restController = new RestController();
    private static final String SYNOPTIC_DATA_URL = "https://energydatacollector.herokuapp.com/danepubliczne/synopticdata";

    @Scheduled(fixedRate = 1800000)
    public void synopticData(){
        System.out.println("Function = synopticData");
        log.info("The time is now {}", dateFormat.format(new Date()));
        System.out.println(restController.sendRequest(SYNOPTIC_DATA_URL));
    }

//    @Scheduled(fixedRate = 3000)
//    public void someApi(){
//        System.out.println("Function = someAPI");
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }

}

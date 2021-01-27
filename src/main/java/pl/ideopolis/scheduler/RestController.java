package pl.ideopolis.scheduler;

import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final RestTemplate restTemplate = new RestTemplate();

    public String sendRequest (String url){
        System.out.println("RestController wysyła request na adres:\n"+url);
        return restTemplate.getForObject(url, String.class);
    }

}

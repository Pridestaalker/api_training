package fr.esiea.ex4A;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;



@RestController
public class MeetMockController {

    private final AgifyService agifyService;

    MeetMockController(AgifyService agifyService) {
        this.agifyService = agifyService;
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Matches> getMatches(@RequestParam(name = "userName") String name, @RequestParam(name = "userCountry") String country) {
        return List.of(
            new Matches("Florian", "Pridestalker98"),
            new Matches("Keanu", "John_Wick")
        );
    }


    @PostMapping(value = "api/inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void inscription(@RequestBody UserInfo userinfo) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2L);
        System.out.println(userinfo.userCountry);


    }
    public static class Matches {
        public final String name;
        public final String twitter;

        public Matches(String name, String twitter) {
            this.name   = name;
            this.twitter    = twitter;
        }
    }
}

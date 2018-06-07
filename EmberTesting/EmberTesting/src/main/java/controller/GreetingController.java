package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetings")

    public ResponseEntity<Map<String, Greeting>> greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
        Greeting greeting = new Greeting(counter.incrementAndGet(),
                String.format(template, name));

        Map<String, Greeting> map = new HashMap<>();
        map.put("greeting", greeting);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}

package hello;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    ConcurrentHashMap<String, Integer> hm= new ConcurrentHashMap<>();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        LocalDateTime n= LocalDateTime.now();
        String key=String.valueOf(n.getMinute());
        Integer val= hm.get(key);
        if(val==null)
            hm.put(key, 1);
        else
            hm.put(key,val+1);

        return new Greeting(key, hm.get(key),String.format(template, name));
    }
}

package hello;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final long id = 100;

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public Greeting greetingGet(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(id, String.format(template, name));
    }
    
    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public Greeting greetingPost(@RequestBody String name) {
        return new Greeting(id, String.format(template, name));
    }
}

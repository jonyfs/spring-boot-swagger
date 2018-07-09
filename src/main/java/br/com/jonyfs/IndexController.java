package br.com.jonyfs;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST,
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Greeting post1(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name));
    }

//    @RequestMapping(path = "/", method = RequestMethod.POST,
//        consumes = {MediaType.APPLICATION_XML_VALUE},
//        produces = {MediaType.APPLICATION_XML_VALUE}
//    )
//    public Greeting post2(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//            String.format(template, name));
//    }

}

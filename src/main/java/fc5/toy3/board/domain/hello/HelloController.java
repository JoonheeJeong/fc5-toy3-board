package fc5.toy3.board.domain.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello, for practice Spring Security!";
    }

    @GetMapping("{something}")
    public String helloSomething(@PathVariable String something) {
        return "Hello, " + something + "!";
    }

}

package task;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/value")
    public int fetchValue() {
        return 1;
    }

    @GetMapping("/text")
    public String fetchText() {
        return "two";
    }

    @GetMapping("/json")
    public Map<String, Integer> fetchJson() {
        return Collections.singletonMap("number", 3);
    }
}

package task;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/test")
    public String postTest(@RequestParam String param) {
        return param;
    }
}

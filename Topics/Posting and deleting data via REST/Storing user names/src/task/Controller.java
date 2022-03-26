package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.*;

@RestController
public class Controller {
    private static int size = 0;
    private ConcurrentHashMap<Integer, String> usersMap = new ConcurrentHashMap<>();

    @GetMapping("/users")
    public Collection<String> getUsers() {
        return usersMap.values();
    }

    @PostMapping("/users")
    public void postUsers(@RequestParam String name) {
        int id = usersMap.size();
        usersMap.put(id, name);
    }

}

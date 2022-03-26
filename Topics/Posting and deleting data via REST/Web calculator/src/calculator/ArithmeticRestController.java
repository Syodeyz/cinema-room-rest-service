package calculator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
class ArithmeticRestController {
    @RequestMapping(value = {"/add", "/subtract", "/mult"}, method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public int calculate(@RequestParam int a, @RequestParam int b) {
        String path = value;

        return operation.equals("add") ? a + b :
                operation.equals("subtract") ? a - b :
                        operation.equals("mult") ? a * b : 0;

    }



}
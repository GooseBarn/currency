package controller;

import java.util.concurrent.atomic.AtomicLong;

import models.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CurrencyController {
    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/currency")
    @ResponseBody
    public Currency sayHello(@RequestParam(name="name", required=false, defaultValue="USD") String name) {
        return new Currency(counter.incrementAndGet(), String.format(template, name));
    }
}

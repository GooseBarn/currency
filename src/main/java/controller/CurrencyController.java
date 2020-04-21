package controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javafx.util.Pair;
import models.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.SomeItemRepository;

@Controller
public class CurrencyController {
    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/currency")
    @ResponseBody
    public Currency sayHello(@RequestParam(name="name", required=false, defaultValue="USD") String name,
                             @RequestParam(name="from", required=false, defaultValue="2019-04-21") String from,
                             @RequestParam(name="to", required=false, defaultValue="2020-04-21") String to) {
        SomeItemRepository repository = new SomeItemRepository();
        try{
            List<Pair<String, Double>> price = repository.getPriceCurrencyFromTo(name, from, to);
            return new Currency(counter.incrementAndGet(), String.format(template, name), price);
        }catch (Exception e){
            return null;
        }

    }
}

package ruhlov.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value="b", required = false) int b,
                            @RequestParam(value="action", required = false) String action,
                            Model model) {
        //System.out.println("hello " + name + " " + surname);
        String result = "";
        switch(action) {
            case ("multiplication"):
                result = a + " * " + b + " = " + (a*b);
                break;
            case ("addition"):
                result = a + " + " + b + " = " + (a+b);
                break;
            case ("subtraction"):
                result = a + " - " + b + " = " + (a-b);
                break;
            case ("division"):
                result = a + " / " + b + " = " + (a/b);
                break;
        }
        model.addAttribute("message", result);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }


}


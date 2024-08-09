package com.avanse.assignment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConsentController {

    @GetMapping("/")
    public String index(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "index";
    }

    @GetMapping("/validateUser")
    public String validateUser(Model model){
        model.addAttribute("user" , "user");
        return "index";
    }

    @GetMapping("/saveUserWisePdf")
    public String saveUserWisePdf(Model model){
        model.addAttribute("user" , "user");
        return "index";
    }


}

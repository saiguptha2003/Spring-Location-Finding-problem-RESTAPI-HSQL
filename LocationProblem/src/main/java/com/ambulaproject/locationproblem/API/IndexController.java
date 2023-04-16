package com.ambulaproject.locationproblem.API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @RequestMapping("/update_user")
    public String userRegistration() {
        return "index";
    }

}

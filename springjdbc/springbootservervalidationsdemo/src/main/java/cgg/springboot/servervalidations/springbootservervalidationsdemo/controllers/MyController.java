package cgg.springboot.servervalidations.springbootservervalidationsdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cgg.springboot.servervalidations.springbootservervalidationsdemo.entities.LoginData;
import jakarta.validation.Valid;

@Controller
public class MyController {
    
    @GetMapping("/form")
    public String openForm(Model m){
        System.out.println("opening form....");
        m.addAttribute("loginData", new LoginData());
        return "form";
    }

    //handler for process form
    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute LoginData loginData,BindingResult result,Model model){
        if (result.hasErrors()) {
            System.out.println(result);
            model.addAttribute("loginData", loginData); // Add the LoginData object to the model to display form data on the form.
            return "form";
        }
        return "success";
    }
}

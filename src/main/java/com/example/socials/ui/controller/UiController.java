package com.example.socials.ui.controller;

import com.example.socials.ui.model.ExecutorScheduler;
import com.example.socials.ui.service.UiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "api/socials/ui")
@AllArgsConstructor
public class UiController {

    private final UiService uiService;


    @GetMapping
    public String index(Model model) {
        model.addAttribute("servicesUrl", uiService.getActiveServices());
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("socialItems", uiService.search());
        return "socialPage";
    }

    @GetMapping("/generator")
    public String getGenerator(Model model) {
        model.addAttribute("generator", uiService.getGenerators());
        return "generator";
    }

    @GetMapping("/delete/{id}")
    public String deleteScheduler(@PathVariable("id") String id) {
        uiService.deleteGenerator(id);
        return "redirect:/api/socials/ui/generator";
    }

    @PostMapping("/addScheduler")
    public String addScheduler(ExecutorScheduler executorScheduler) {
        uiService.addGenerator(executorScheduler);
        return "redirect:/api/socials/ui/generator";
    }

    @GetMapping("/forceExecute/{id}")
    public String forceExecute(@PathVariable("id") String id) {
        uiService.forceExecute(id);
        return "redirect:/api/socials/ui/generator";
    }

}

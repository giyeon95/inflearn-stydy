package com.hello.typeconverter.controller;

import com.hello.typeconverter.dto.Form;
import com.hello.typeconverter.type.IpPort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConverterController {

    @GetMapping("/converter-view")
    public String converterView(Model model) {
        model.addAttribute("number", 10000);
        model.addAttribute("ipPort", new IpPort("127.0.0.1", 8080));

        return "converter-view";
    }

    @GetMapping("/converter/edit")
    public String converterForm(Model model) {
        IpPort ipPort = new IpPort("127.0.0.1", 8080);

        model.addAttribute("form", new Form(ipPort));
        return "converter-form";
    }

    @PostMapping("/converter/edit")
    public String conveterEdit(@ModelAttribute Form form, Model model) {
        IpPort ipPort = form.ipPort();
        model.addAttribute("ipPort", ipPort);

        return "converter-view";
    }

}


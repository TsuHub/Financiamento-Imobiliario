package com.financingrequest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FinancingRequestController
{
    @RequestMapping("/formulario")
    public String formFinancingRequest() {
        return "form/form_financing_request";
    }
}

package com.packt.webapp.controller;

import com.packt.webapp.service.BazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SzukajControler
{
  @Autowired
  private BazaService bazaService;
  
  @RequestMapping({"/test"})
  public String list(Model model)
  {
    String lek = "%Gabap%";
    
    model.addAttribute("leki", this.bazaService.findall(lek));
    
    return "welcome";
  }
}

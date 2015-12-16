package com.packt.webapp.controller;

import com.packt.webapp.domain.Lek;
import com.packt.webapp.service.BazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SzukajControler
{
  @Autowired
  private BazaService bazaService;
  
  @RequestMapping({"/"})
  public String list(Model model)
  {
    String lek = "%Gabap%";
    
    model.addAttribute("leki", this.bazaService.findall(lek));
    
    return "welcome";
  }
  
  
  @RequestMapping(value ="/szukaj", method = RequestMethod.GET)
  public String addLeki(Model model)
  {
   Lek newLek = new Lek();
   model.addAttribute("newLek", newLek);
   return "szukaj";
  }
  
  @RequestMapping(value ="/szukaj", method = RequestMethod.POST)
  public String getAddLek(@ModelAttribute("newLek") Lek newlek, Model model)
  {
	  String lek = newlek.getLek();
	  model.addAttribute("lekLista", this.bazaService.findall(lek));
   return "redirect:/szukaj";
  
}
}


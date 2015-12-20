package com.packt.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webapp.domain.Pacjent;
import com.packt.webapp.service.BazaService;

@Controller
public class AptekaControler {

	  @Autowired
	  private BazaService bazaService;
	  
	
	  
	  @RequestMapping(value ="/apteka", method = RequestMethod.GET)
	  public String addLeki(Model model)
	  {
	   Pacjent newPacjent = new Pacjent();
	   model.addAttribute("newPacjent", newPacjent);
	   return "apteka";
	  }
	  @RequestMapping(value ="/apteka", method = RequestMethod.POST)
	  public String getAddLek(@ModelAttribute("newPacjent") Pacjent newPacjent, Model model)
	  {
		 Integer pesel = newPacjent.getPesel();
		 System.out.println("Recepta find: "+ pesel);
		 System.out.println("Recepta find: "+ bazaService.findRecepta(pesel));
		 model.addAttribute("recepta", bazaService.findRecepta(pesel));
		  
		  return "apteka";
	  
	}
}

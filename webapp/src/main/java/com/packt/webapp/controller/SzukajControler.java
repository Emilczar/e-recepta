package com.packt.webapp.controller;

import com.packt.webapp.domain.Lek;
import com.packt.webapp.service.BazaService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SzukajControler
{
	
ArrayList<String> ListaLekow = new ArrayList<String>();

  @Autowired
  private BazaService bazaService;
  
  @RequestMapping({"/"})
  public String list(Model model)
  {
  //  String lek = "%as%";
    
    //model.addAttribute("leki", this.bazaService.findall(lek));
    
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
	  String lek_1 = newlek.getLek();
	  String lek = "%"+lek_1+"%";
	  System.out.println("test "+ this.bazaService.findall(lek));
	  model.addAttribute("lekLista", this.bazaService.findall(lek));

	  return "szukaj";
  
}
  @RequestMapping(value ="/szukaj/{lekLista}", method = RequestMethod.GET)
  public String wynikAdd(@PathVariable("lekLista") String lek, Model model)
  {
	  model.addAttribute("lekLista", lek);
	  ListaLekow.add(lek);
	  return "addlek" ;
  }
  
  @RequestMapping({"/lista"})
  public String list1(Model model)
  { 
    model.addAttribute("leki", ListaLekow );
    System.out.println("Lista: "+ ListaLekow);
    return "lista";
  }
  @RequestMapping("/usun/{lekLista}")
  public String usunZlistyLekow(@PathVariable("lekLista") String lek, Model model)
  {
	  ListaLekow.remove(lek);
	  return "redirect:/lista";
  }
  
}


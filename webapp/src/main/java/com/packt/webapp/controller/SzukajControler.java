package com.packt.webapp.controller;

import com.packt.webapp.domain.Lek;
import com.packt.webapp.domain.Pacjent;
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
	
ArrayList<String> listaLekow = new ArrayList<String>();
String[] tablek = new  String[5];
String lek1 ="";
String lek2 ="";
String lek3 ="";
String lek4 ="";
String lek5 ="";
int liczba;
int stan = 0;
int pesel;
  @Autowired
  private BazaService bazaService;
  
  @RequestMapping({"/"})
  public String list(Model model)
  {
  //  String lek = "%as%";
	  System.out.println("liczba wierszy "+ bazaService.CountROW());
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
	//  System.out.println("test "+ this.bazaService.findall(lek));
	  model.addAttribute("lekLista", this.bazaService.findall(lek));

	  return "szukaj";
  
}
  @RequestMapping(value ="/szukaj/{lekLista}", method = RequestMethod.GET)
  public String wynikAdd(@PathVariable("lekLista") String lek, Model model)
  {
	  model.addAttribute("lekLista", lek);
	  listaLekow.add(lek);
	  liczba = listaLekow.size();
	  return "addlek" ;
  }
  
  @RequestMapping({"/lista"})
  public String list1(Model model)
  { 
	 liczba = listaLekow.size();
    model.addAttribute("leki", listaLekow );
    model.addAttribute("licznik", liczba );
    System.out.println("LICZNIK: "+ liczba);
    return "lista";
  }
  @RequestMapping("/usun/{lekLista}")
  public String usunZlistyLekow(@PathVariable("lekLista") String lek, Model model)
  {
	  listaLekow.remove(lek);
	  return "redirect:/lista";
  }
  
  @RequestMapping(value ="/pesel", method = RequestMethod.GET)
  public String peselget(Model model)
  {
   Pacjent newPacjent = new Pacjent();
   model.addAttribute("newPacjent", newPacjent);
   return "pesel";
  }
  
  @RequestMapping(value ="/pesel", method = RequestMethod.POST)
  public String peselpost(@ModelAttribute("newPacjent") Pacjent newPacjent, Model model)
  {
	 pesel=newPacjent.getPesel();
		System.out.println("pesel: "+ pesel);
	  return "pesel";
  
}
  
  @RequestMapping({"/wyslij"})
  public String wyslijRecepte(Model model)
  { 
	  int i = 0;
	 
	 int id = bazaService.CountROW()+1;
	
		System.out.println("pesel2: "+ pesel);
	 for (String string : listaLekow) {
		tablek[i++] = string;
	}
	
	
	System.out.println("BAZA");
	bazaService.insertLek(id, pesel, stan, tablek[0], tablek[1], tablek[2], tablek[3], tablek[4]);
	
    model.addAttribute("leki",listaLekow );
    System.out.println("Lista: "+ listaLekow);
    listaLekow.clear();
    for (int j = 0; j < 5; j++) {
		tablek[j] = "";
	}
    return "wyslij";
    
  }
}


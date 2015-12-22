package com.packt.webapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webapp.domain.Pacjent;
import com.packt.webapp.service.BazaService;

@Controller
public class AptekaControler {
	ArrayList<String> rozmiar = new ArrayList<String>();
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
		 rozmiar.clear();
		 Integer pesel = newPacjent.getPesel();
		 
		 rozmiar.addAll(bazaService.findReceptaAll(pesel));
		 int roz = rozmiar.size();
		 
		 
		 System.out.println("Recepta find: "+ pesel);
		 System.out.println("rozmiar: "+ rozmiar.size());
		 System.out.println("Recepta find: "+ bazaService.findReceptaAll(pesel));
		 String brak = ("brak aktualnej recepty");
		 System.out.println("Recepta find: "+ brak);
		 
		 if (roz == 0) {
			 model.addAttribute("uwaga", brak);
		} else {
			model.addAttribute("recepta", bazaService.findReceptaAll(pesel));
		}
		
		  return "apteka";
	  
	}
	  @RequestMapping(value ="/apteka/{receptaID}", method = RequestMethod.GET)
	  public String wynikAdd(@PathVariable("receptaID") Integer receptaID, Model model)
	  {
		
		System.out.println("leki z recepty:: "+ bazaService.findReceptaID(receptaID));
		model.addAttribute("listaId", bazaService.findReceptaID(receptaID));
		model.addAttribute("Id", receptaID );
		  
		  return "recepta" ;
	  }
	  
	  
	  @RequestMapping(value ="/apteka/wykonaj/{Id}", method = RequestMethod.GET)
	  public String wykonaieReceptyID(@PathVariable("Id") Integer id, Model model)
	  {
		
		  	bazaService.updateReceptaID(id);
		  	model.addAttribute("wykonaj", id);
	
		  
		  return "wykonane" ;
	  }
	  
	  
	  
}

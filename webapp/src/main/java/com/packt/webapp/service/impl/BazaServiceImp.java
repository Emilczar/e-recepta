package com.packt.webapp.service.impl;

import com.packt.webapp.dao.LekDao;
import com.packt.webapp.service.BazaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BazaServiceImp
  implements BazaService
{
  @Autowired
  private LekDao lekdao;
  
  public List<String> findall(String leknazwa)
  {
    return this.lekdao.findall(leknazwa);
  }

public int CountROW() {
	
	return lekdao.CountROW();
}



public void insertLek(int id, int pesel, int stan, String lek1, String lek2, String lek3, String lek4, String lek5) {
	lekdao.insertLek(id, pesel, stan, lek1, lek2, lek3, lek4, lek5);
	
}


//apteka

public List<String> findReceptaAll(Integer pesel) {
	
	return lekdao.findReceptaAll(pesel);
}

public List<String> findReceptaID(Integer id) {
	
	return lekdao.findReceptaID(id);
}

public void updateReceptaID(Integer id) {
	lekdao.updateReceptaID(id);
	
}


  
  
}

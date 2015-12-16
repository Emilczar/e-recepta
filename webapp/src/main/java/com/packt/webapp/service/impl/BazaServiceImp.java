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
}

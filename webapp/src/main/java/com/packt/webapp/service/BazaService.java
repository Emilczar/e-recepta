package com.packt.webapp.service;

import java.util.List;

public abstract interface BazaService
{
  public abstract List<String> findall(String paramString);
  public int CountROW();
  public void insertLek(int id, int pesel, int stan, String lek1, String lek2, String lek3, String lek4, String lek5);

  //apteka
  
  public List<String> findReceptaAll(Integer pesel);
  public List<String> findReceptaID(Integer id);
  public void updateReceptaID(Integer id);
}

package com.packt.webapp.dao;

import com.packt.webapp.domain.Lek;
import java.util.List;

public abstract interface LekDao
{
  public abstract Lek findLek(String paramString);
  
  public abstract List<String> findall(String paramString);
  
  public abstract List<Lek> findLekall(String paramString);
  
  public int CountROW();
  
  public void insertLek(int id, int pesel, int stan, String lek1, String lek2, String lek3, String lek4, String lek5);
}

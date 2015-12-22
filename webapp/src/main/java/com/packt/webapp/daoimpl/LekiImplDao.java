package com.packt.webapp.daoimpl;

import com.packt.webapp.dao.LekDao;
import com.packt.webapp.domain.Lek;
import com.packt.webapp.domain.LekiRowMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;

public class LekiImplDao
  implements LekDao
{
  private DataSource dataSource;
  
  public void setDataSource(DataSource dataSource)
  {
    this.dataSource = dataSource;
  }
  
  public Lek findLek(String lek)
  {
    String sql = "SELECT * FROM baza1 WHERE lek LIKE ? ";
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    Lek leki = (Lek)jdbcTemplate.queryForObject(sql, new Object[] { lek }, new LekiRowMapper());
    return leki;
  }
  
  public List<String> findall(String lek2)
  {
    String sql2 = "SELECT * FROM baza1 WHERE lek LIKE ?";
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    List<String> leklista = new ArrayList();
    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql2, new Object[] { lek2 });
    for (Map<String, Object> row : rows)
    {
      String lek1 = (String)row.get("lek");
      leklista.add(lek1);
    }
    return leklista;
  }
  
  public List<Lek> findLekall(String lek)
  {
    String sql = "SELECT lek FROM baza1";
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    List<Lek> listLek = new ArrayList();
    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
    for (Map<String, Object> row : rows)
    {
      Lek lekdom = new Lek();
      lekdom.setLek((String)row.get("lek"));
      listLek.add(lekdom);
    }
    return listLek;
  }

public int CountROW() {
	String sql = "SELECT * FROM recepta";
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);

    RowCountCallbackHandler countCallback = new RowCountCallbackHandler();  // not reusable
    jdbcTemplate.query(sql, countCallback);
    int rowCount = countCallback.getRowCount();
	return rowCount;
}



public void insertLek(int id, int pesel, int stan, String lek1, String lek2, String lek3, String lek4, String lek5) {

	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
	jdbcTemplate.update("insert into recepta (id, pesel, stan, lek1,lek2,lek3,lek4,lek5) values (?,?,?,?,?,?,?,?)" ,id, pesel, stan, lek1, lek2, lek3, lek4,lek5);
}

//apteka


public List<String> findReceptaAll(Integer pesel) {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
	 String sql = "SELECT id  FROM recepta where pesel = ? AND stan = 0";
	
	 
	 List<String> receptaLista = new ArrayList();
	    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { pesel });
	    for (Map<String, Object> row : rows)
	    {
	      String id1 = (String)row.get("id");
	      receptaLista.add(id1);
	    }
	    return receptaLista;
	
}

public List<String> findReceptaID(Integer id) {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
	 String sql = "SELECT lek1, lek2, lek3, lek4, lek5  FROM recepta where id = ? ";
	 List<String> listaLekow = new ArrayList();
	 List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { id });
	   for (Map<String, Object> row : rows)
	    {
	      String lek1 = (String)row.get("lek1");
	      listaLekow.add(lek1);
	      String lek2 = (String)row.get("lek2");
	      listaLekow.add(lek2);
	      String lek3 = (String)row.get("lek3");
	      listaLekow.add(lek3);
	      String lek4 = (String)row.get("lek4");
	      listaLekow.add(lek4);
	      String lek5 = (String)row.get("lek5");
	      listaLekow.add(lek5);
	    }
	 
	return listaLekow;
}

public void updateReceptaID(Integer id) {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
	 String sql = "UPDATE recepta SET stan = 1 WHERE id = ?";
	 jdbcTemplate.update(sql, id);
}


  
}

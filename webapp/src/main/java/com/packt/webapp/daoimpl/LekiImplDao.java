package com.packt.webapp.daoimpl;

import com.packt.webapp.dao.LekDao;
import com.packt.webapp.domain.Lek;
import com.packt.webapp.domain.LekiRowMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

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
}

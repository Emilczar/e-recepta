package com.packt.webapp.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LekiRowMapper
  implements RowMapper<Lek>
{
  public Lek mapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    Lek lek = new Lek();
    lek.setLek(rs.getString("lek"));
    
    return lek;
  }
}

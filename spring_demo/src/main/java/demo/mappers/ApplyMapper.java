package demo.mappers;

import demo.entity.Apply;
import demo.entity.Record;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplyMapper implements RowMapper<Apply>{

    @Override
    public Apply mapRow(ResultSet rs,int i) throws SQLException {
        Apply apply = new Apply();
        apply.setName(rs.getString("name"));
        apply.setType(rs.getInt("type"));
        apply.setDate(rs.getString("date"));
        apply.setDays(rs.getInt("days"));
        apply.setTime(rs.getString("time"));
        apply.setDivmanager(rs.getInt("divmanager"));
        apply.setDepmanager(rs.getInt("depmanager"));
        apply.setGenmanager(rs.getInt("genmanager"));
        apply.setResult(rs.getInt("result"));
        return apply;
    }
}

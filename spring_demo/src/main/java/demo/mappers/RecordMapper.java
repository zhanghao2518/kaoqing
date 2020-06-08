package demo.mappers;

import demo.entity.Record;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordMapper implements RowMapper<Record>{

    @Override
    public Record mapRow(ResultSet rs,int i) throws SQLException {
        Record record = new Record();
        record.setName(rs.getString("name"));
        record.setTime(rs.getString("time"));
        record.setAbnormal(rs.getInt("abnormal"));
        return record;
    }
}

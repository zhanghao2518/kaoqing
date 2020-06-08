package demo.dao;

import demo.entity.Record;

import demo.mappers.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockinDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Record> queryAllRecords(String name) {
        String sql = "SELECT * FROM record WHERE name=?";
        List<Record> recordList = jdbcTemplate.query(sql, new RecordMapper(),name);
        return recordList;
    }

    public List<Record> queryRecords() {
        String sql = "SELECT * FROM record";
        List<Record> recordList = jdbcTemplate.query(sql, new RecordMapper());
        return recordList;
    }

    public Record insertRecord(Record record){
        String sql = "INSERT INTO record (name,time,abnormal) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, record.getName(), record.getTime(), record.getAbnormal());
        String sql2 = "SELECT * FROM record WHERE name=? AND time=? ";
        Record record1 = jdbcTemplate.queryForObject(sql2, new RecordMapper(), record.getName(),record.getTime());
        return record1;
    }
}

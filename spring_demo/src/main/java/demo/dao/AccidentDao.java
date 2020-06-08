package demo.dao;

import demo.entity.Apply;

import demo.mappers.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Apply insertApply(Apply apply){
        String sql = "INSERT INTO apply (name,type,date,days,time,divmanager,depmanager,genmanager,result) VALUES(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, apply.getName(), apply.getType(),
                apply.getDate(),apply.getDays(),apply.getTime(),
                apply.getDivmanager(),apply.getDepmanager(),apply.getGenmanager(),apply.getResult());
        String sql2 = "SELECT * FROM apply WHERE name=? AND time=? ";
        Apply apply1 = jdbcTemplate.queryForObject(sql2, new ApplyMapper(),apply.getName(),apply.getTime());
        return apply1;
    }

    public Apply queryApply(String name,String date){
        String sql = "SELECT * FROM apply WHERE name=? AND date=? ";
        Apply apply = jdbcTemplate.queryForObject(sql, new ApplyMapper(), name,date);
        return apply;
    }

    public List<Apply> queryNameApply(String name){
        String sql = "SELECT * FROM apply WHERE name=?";
        List<Apply> applies= jdbcTemplate.query(sql,new ApplyMapper(),name);
        return applies;
    }

    public List<Apply> queryAllApply(){
        String sql = "SELECT * FROM apply";
        List<Apply> applies= jdbcTemplate.query(sql,new ApplyMapper());
        return applies;
    }

    public void deleteApply(String name,String date) {
        String sql = "DELETE FROM student WHERE name=? AND date=?";
        jdbcTemplate.update(sql,name,date);
    }

}

package demo.dao;

import demo.entity.User;
import demo.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User queryUserByName(String name) {
        String sql = "SELECT * FROM users WHERE name=? ";
        User user = jdbcTemplate.queryForObject(sql, new UserMapper(), name);
        return user;
    }
}

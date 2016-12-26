package com.sbrf.dao.api;

import com.sbrf.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDAO implements GenericDAO<User> {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public long create(User user) {
        String sql = "INSERT INTO user(login, password) VALUES(:login, :password)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);
        return (Long) keyHolder.getKey();
    }

    @Override
    public User read(long id) {
        return (User) jdbcTemplate.queryForObject("SELECT id, login, password FROM user WHERE id = ?",
                new Object[] {id},
                new BeanPropertyRowMapper(User.class));
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET login = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getLogin(), user.getPassword(), user.getId());
    }

    @Override
    public void delete(User user) {

    }

    public boolean checkByLogin(String login) {
        String sql = "SELECT COUNT(*) FROM user WHERE login = ?";
        int countOfLogin = jdbcTemplate.queryForObject(sql, Integer.class, login);
        return countOfLogin >= 1;
    }

    public User readByLogin(String login) {
        return  (User) jdbcTemplate.queryForObject("SELECT id, login, password FROM user WHERE login = ?",
                new Object[] {login},
                new BeanPropertyRowMapper(User.class));
    }

    public User findByLoginAndPassword(String login, String password) {
        return  (User) jdbcTemplate.queryForObject("SELECT id, login, password FROM user WHERE login = ? AND password = ?",
                new Object[] {login, password},
                new BeanPropertyRowMapper(User.class));
    }
}

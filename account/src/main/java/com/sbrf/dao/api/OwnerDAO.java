package com.sbrf.dao.api;

import com.sbrf.dao.model.Owner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class OwnerDAO implements GenericDAO<Owner> {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public OwnerDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long create(Owner owner) {
        String sql = "INSERT INTO owner(firstName, middleName, lastName, user_id) VALUES(:firstName, :middleName, :lastName, :userId)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(owner);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);
        return (Long) keyHolder.getKey();
    }

    @Override
    public Owner read(long id) {
        return null;
    }

    @Override
    public void update(Owner owner) {

    }

    @Override
    public void delete(Owner owner) {

    }
}

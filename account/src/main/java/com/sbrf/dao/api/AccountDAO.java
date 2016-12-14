package com.sbrf.dao.api;

import com.sbrf.dao.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountDAO implements GenericDAO<Account> {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AccountDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long create(Account account) {
        String sql = "INSERT INTO account(number, money, owner_id) VALUES(:number, :money, :owner)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(account);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);
        return (Long) keyHolder.getKey();
    }

    @Override
    public Account read(long id) {
        return (Account) jdbcTemplate.queryForObject("SELECT id, number, money, owner_id FROM account WHERE id = ?",
                new Object[] {id},
                new BeanPropertyRowMapper(Account.class));
    }

    @Override
    public void update(Account account) {
        String sql = "UPDATE account SET number = ?, money = ?, owner_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, account.getNumber(), account.getMoney(), account.getOwner(), account.getId());
    }

    public void updateMoney(Account account, BigDecimal money) {
        String sql = "UPDATE account SET money = ? WHERE id = ?";
        jdbcTemplate.update(sql, money, account.getId());
    }

    @Override
    public void delete(Account account) {

    }
}

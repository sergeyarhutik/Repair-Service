package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


/**
 * Client DAO Interface implementation.
 */
@Component
public class ClientDaoImpl implements ClientDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final String CLIENT_ID = "clientId";

    @Value("${client.findAll}")
    private String findAllSql;

    @Value("${client.findById}")
    private String findByIdSql;

    @Value("${client.insert}")
    private String insertSql;

    @Value("${client.update}")
    private String updateSql;

    @Value("${client.delete}")
    private String deleteSql;

    public ClientDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Client add(Client client) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("clientName", client.getClientName());
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insertSql, parameters, generatedKeyHolder);
        client.setClientId(generatedKeyHolder.getKey().intValue());
        return client;
    }

    @Override
    public void update(Client client) {
        if (namedParameterJdbcTemplate.update(updateSql, new BeanPropertySqlParameterSource(client)) < 1) {
            throw new EmptyResultDataAccessException(
                    String.format("Failed to update. '%s' not found in the DB", client), 1);
        }
    }

    private boolean successfullyUpdated(int numRowsUpdated) {
        return numRowsUpdated > 0;
    }

    @Override
    public void delete(Integer clientId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(CLIENT_ID, clientId);
        Optional.of(namedParameterJdbcTemplate.update(deleteSql, mapSqlParameterSource))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Failed to delete client from DB"));
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = namedParameterJdbcTemplate.query(findAllSql, new ClientRowMapper());
        return clients;
    }

    @Override
    public Optional<Client> findById(Integer clientId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(CLIENT_ID, clientId);
        List<Client> results = namedParameterJdbcTemplate.query(findByIdSql, namedParameters,
                BeanPropertyRowMapper.newInstance(Client.class));
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }

    private class ClientRowMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            Client client = new Client();
            client.setClientId(resultSet.getInt("client_id"));
            client.setClientName(resultSet.getString("client_name"));
            return client;
        }
    }
}

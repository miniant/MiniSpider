package net.ant.core.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


/**
 * 基础DAO
 *
 * @author lsr
 * @version 2013-1-11
 */
@Repository("baseDao")
public class BaseDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    
    private static final int MAX_ROWS = 100;
    private static final int FETCH_SIZE = 100;
    
    @PostConstruct
    public void init(){
        jdbcTemplate.setMaxRows(MAX_ROWS);
        jdbcTemplate.setFetchSize(FETCH_SIZE);
    }
    
    public int queryForInt(String sql){
        return jdbcTemplate.queryForInt(sql);
    }
    
    public int queryForInt(String sql, Object[] params){
        return jdbcTemplate.queryForInt(sql, params);
    }
    
    public long queryForLong(String sql){
        return jdbcTemplate.queryForLong(sql);
    }
    
    public long queryForLong(String sql, Object[] params){
        return jdbcTemplate.queryForLong(sql, params);
    }
    
    public <T> List<T> queryForList(String sql, Object[] params, RowMapper<T> rowMapper){
        return jdbcTemplate.query(sql, params, rowMapper);
    }
    
    public <T> List<T> queryForList(String sql, RowMapper<T> rowMapper){
        return jdbcTemplate.query(sql, rowMapper);
    }
    
    public <T> T queryForObject(String sql, Object[] params, RowMapper<T> rowMapper){
        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }
    
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper){
        return jdbcTemplate.queryForObject(sql, rowMapper);
    }
    
    public void update(String sql, Object[] params){
        jdbcTemplate.update(sql, params);
    }
    
    public void update(String sql){
        jdbcTemplate.update(sql);
    }
}

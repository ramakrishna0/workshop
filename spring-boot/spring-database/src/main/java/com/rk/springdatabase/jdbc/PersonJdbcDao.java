package com.rk.springdatabase.jdbc;

import com.rk.springdatabase.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class PersonJdbcDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final PersonRowMapper rowMapper = new PersonRowMapper();

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> findAll() {
//        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
        return jdbcTemplate.query("select * from person", rowMapper);
    }

    public Person findById(int id) {
//        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id}, new int[]{Types.INTEGER}, new BeanPropertyRowMapper<>(Person.class));
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id}, new int[]{Types.INTEGER}, rowMapper);
    }

    public List<Person> findByLocation(String location) {
//        return jdbcTemplate.query("select * from person where location=?", new Object[]{location}, new int[]{Types.VARCHAR}, new BeanPropertyRowMapper<>(Person.class));
        return jdbcTemplate.query("select * from person where location=?", new Object[]{location}, new int[]{Types.VARCHAR}, rowMapper);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", id);
    }

    public int insert(Person person) {
        return jdbcTemplate.update(
                "insert into person (id, name, location, birth_date) values (?, ?, ?, ?)",
                person.getId(), person.getName(), person.getLocation(), person.getBirthDate()
        );
    }

    public int update(Person person) {
        return jdbcTemplate.update(
                "update person set name=?, location=?, birth_date=? where id=?",
                person.getName(), person.getLocation(), person.getBirthDate(), person.getId()
        );
    }

}

package me.xiao.springlearn;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 数据库操作
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/7 13:29
 */

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
    private static final Logger logger = Logger.getLogger(JdbcApplication.class);

    @Autowired
    public JdbcApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Creating databases");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS ");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        List<Object[]> splitUpNames = Stream.of("John Woo", "Jeff Dean")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        splitUpNames.forEach(name -> logger.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name,last_name) VALUES (?,?)", splitUpNames);

        logger.info("Query for customer records where first_name = 'Jeff': ");

        jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name=?", new Object[]{"Jeff"},
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
                .forEach(customer -> logger.info(customer.toString()));

    }
}

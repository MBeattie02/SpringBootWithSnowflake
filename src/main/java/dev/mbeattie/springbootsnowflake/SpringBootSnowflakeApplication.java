package dev.mbeattie.springbootsnowflake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class SpringBootSnowflakeApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootSnowflakeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSnowflakeApplication.class, args);
    }

    @Bean
    public CommandLineRunner checkConnection(DataSource dataSource) {
        return args -> {
            try (Connection connection = dataSource.getConnection()) {
                if (connection.isValid(5)) {
                    logger.info("Successfully connected to Snowflake!");
                } else {
                    logger.error("Failed to connect to Snowflake.");
                }
            } catch (SQLException e) {
                logger.error("Error connecting to Snowflake: {}", e.getMessage(), e);
            }
        };
    }
}

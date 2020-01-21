package lv.helloit.switter;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfiguration {
    private static final String DB_URL = "jdbc:postgresql://ec2-54-247-181-232.eu-west-1.compute.amazonaws.com:5432/ddlvu5pf94g6u3";
    private static final String DB_USER = "ubtflmsvlsvcla";
    private static final String DB_PASSWORD = "b874bc49a245517ecaf7de62b7fd42bde8e08a445eef647e20804376ca045bd9";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    @Bean
    DataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(DB_URL);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PASSWORD);
        ds.setDriverClassName(DB_DRIVER);
        ds.setMaxTotal(3);
        return ds;
    }
}

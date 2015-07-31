package simpleblog.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by marc on 11/07/15.
 */
@Configuration
public class SpringDataConfig {

    @Autowired
    private Environment env;


    // Declare a datasource that has pooling capabilities
    @Bean
    public DataSource dataSource() {
        try {
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
            ds.setUrl(env.getRequiredProperty("jdbc.url"));
            ds.setUsername(env.getRequiredProperty("jdbc.username"));
            ds.setPassword(env.getRequiredProperty("jdbc.password"));

            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate(dataSource());
        return template;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        // http://www.baeldung.com/hibernate-4-spring
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        sessionFactory.setHibernateProperties(properties);

        sessionFactory.setPackagesToScan("simpleblog.models");

        return sessionFactory;
    }

}

package simpleblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import simpleblog.domain.BlogPost;
import simpleblog.domain.BlogPostDao;

import javax.sql.DataSource;

/**
 * Created by marc on 11/07/15.
 */
@Configuration
public class SpringDataConfig {

    @Autowired
    private Environment env;


    // Declare a datasource that has pooling capabilities
    @Bean
    public DataSource dataSource()
    {
        try
        {
            DriverManagerDataSource ds = new DriverManagerDataSource();
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
    public JdbcTemplate jdbcTemplate()
    {
        JdbcTemplate template = new JdbcTemplate(dataSource());
        return template;
    }

}

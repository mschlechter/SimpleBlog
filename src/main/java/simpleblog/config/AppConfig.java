package simpleblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by marc on 4-7-15.
 */
@Configuration
@ComponentScan(basePackages = "simpleblog")
@PropertySource("classpath:simpleblog.properties")
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer ApplicationPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}

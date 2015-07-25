package simpleblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import simpleblog.services.CustomUserDetailsServiceImpl;

/**
 * Created by marc on 12/07/15.
 *
 * http://www.mkyong.com/spring-security/spring-security-hibernate-annotation-example/
 *
 * http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#what-is-acegi-security
 *
 * http://stackoverflow.com/questions/8535083/get-more-information-from-user-spring-security
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/post/edit/**").hasRole("ADMIN")
                .antMatchers("/post/save**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .and().csrf();
    }

}

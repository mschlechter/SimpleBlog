package simpleblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import simpleblog.models.BlogUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by marc on 25/07/15.
 *
 * http://fruzenshtein.com/spring-mvc-security-mysql-hibernate/
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    BlogUserService blogUserService;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        BlogUser blogUser = blogUserService.getUserByName(login);

        if (blogUser != null)
        {
            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            return new CustomUserDetails(
                    blogUser.getUsername(),
                    blogUser.getPassword(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(blogUser.getRole()),
                    blogUser.getFriendlyName()
            );

        }

        return null;

    }


    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    public List<String> getRoles(Integer role) {

        List<String> roles = new ArrayList<String>();

        if (role >= 1) roles.add("ROLE_USER");
        if (role >= 2) roles.add("ROLE_ADMIN");

        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}

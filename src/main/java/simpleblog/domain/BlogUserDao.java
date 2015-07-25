package simpleblog.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by marc on 25/07/15.
 */
@Repository
public class BlogUserDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BlogUser getUserByName(String username)
    {
        String sql = "select * from bloguser where username = ?";

        BlogUser user = (BlogUser)jdbcTemplate.queryForObject(sql,
                new Object[] { username },
                new BeanPropertyRowMapper(BlogUser.class));

        return user;
    }

}

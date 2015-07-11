package simpleblog.domain;

import org.markdown4j.Markdown4jProcessor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by marc on 11/07/15.
 */
public class BlogPostDao {

    private JdbcTemplate jdbcTemplate;

    public BlogPostDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BlogPost> getRecentPosts()
    {
        String sql = "select * from blogpost";

        List<BlogPost> blogPostList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BlogPost.class));

        Markdown4jProcessor p = new Markdown4jProcessor();

        for (BlogPost blogPost : blogPostList)
        {
            try {
                String html = p.process(blogPost.getContentmd());

                html = html.replaceAll("<pre>", "<pre class=\"prettyprint\">");


                blogPost.setContenthtml(html);
            }
            catch (IOException e)
            {

            }

        }


        return blogPostList;
    }


}

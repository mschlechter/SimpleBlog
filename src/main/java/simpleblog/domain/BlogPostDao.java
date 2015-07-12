package simpleblog.domain;

import org.markdown4j.Markdown4jProcessor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * Created by marc on 11/07/15.
 */
@Repository
public class BlogPostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BlogPost> getRecentPosts()
    {
        String sql = "select * from blogpost order by created desc limit 5";

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

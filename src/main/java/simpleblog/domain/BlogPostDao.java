package simpleblog.domain;

import org.markdown4j.Markdown4jProcessor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import simpleblog.services.MarkdownProcessor;

import java.io.IOException;
import java.util.List;

/**
 * Created by marc on 11/07/15.
 */
@Repository
public class BlogPostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MarkdownProcessor mdProcessor;

    public List<BlogPost> getRecentPosts()
    {
        String sql = "select * from blogpost order by created desc limit 5";

        List<BlogPost> blogPostList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BlogPost.class));

        for (BlogPost blogPost : blogPostList)
        {
            String html = mdProcessor.getHtml(blogPost.getContentmd());
            blogPost.setContenthtml(html);
        }
        return blogPostList;
    }

    public BlogPost getBlogPost(int id)
    {
        String sql = "select * from blogpost where id = ?";

        BlogPost blogPost = (BlogPost)jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper(BlogPost.class));

        String html = mdProcessor.getHtml(blogPost.getContentmd());
        blogPost.setContenthtml(html);

        return blogPost;
    }

}

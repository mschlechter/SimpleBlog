package simpleblog.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import simpleblog.services.MarkdownProcessor;

import java.util.Date;
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

    public List<BlogPost> getBlogPostSummary()
    {
        String sql = "select id, title, summary, created from blogpost order by created desc";

        List<BlogPost> blogPostList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(BlogPost.class));

        for (BlogPost blogPost : blogPostList)
        {
            blogPost.setSummaryHtml(mdProcessor.getHtml(blogPost.getSummary()));
        }

        // test ssh

        return blogPostList;
    }



}

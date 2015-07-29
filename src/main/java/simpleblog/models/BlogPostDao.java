package simpleblog.models;

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

    public List<BlogPost> getRecentPosts()
    {
        String sql = "select * from blogpost order by created desc limit 5";

        List<BlogPost> blogPostList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(BlogPost.class));

        for (BlogPost blogPost : blogPostList)
        {
            blogPost.setContentHtml(mdProcessor.getHtml(blogPost.getContent()));
            blogPost.setSummaryHtml(mdProcessor.getHtml(blogPost.getSummary()));
        }
        return blogPostList;
    }

    public BlogPost getBlogPost(int id)
    {
        String sql = "select * from blogpost where id = ?";

        BlogPost blogPost = (BlogPost)jdbcTemplate.queryForObject(sql,
                new Object[] { id },
                new BeanPropertyRowMapper(BlogPost.class));

        blogPost.setContentHtml(mdProcessor.getHtml(blogPost.getContent()));
        blogPost.setSummaryHtml(mdProcessor.getHtml(blogPost.getSummary()));

        return blogPost;
    }

    public List<BlogPost> getBlogPostSummary()
    {
        String sql = "select id, title, summary, created from blogpost order by created desc";

        List<BlogPost> blogPostList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(BlogPost.class));

        for (BlogPost blogPost : blogPostList)
        {
            blogPost.setSummaryHtml(mdProcessor.getHtml(blogPost.getSummary()));
        }

        return blogPostList;
    }

    public void saveBlogPost(BlogPost blogPost)
    {
        if (blogPost.isNew())
        {
            String sql = "insert into blogpost(id, title, created, content, summary) values (nextval('seq_blogpost'), ?, ?, ?, ?)";

            jdbcTemplate.update(sql,
                    new Object[]{
                            blogPost.getTitle(), new Date(), blogPost.getContent(), blogPost.getSummary()
                    });

        }
        else
        {
            String sql = "update blogpost set title = ?, created = ?, summary = ?, content = ? where id = ?";
            jdbcTemplate.update(sql,
                    new Object[] {
                            blogPost.getTitle(), new Date(), blogPost.getSummary(), blogPost.getContent(), blogPost.getId()
                    });
        }
    }

}

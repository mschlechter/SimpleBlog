package simpleblog.domain;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import simpleblog.services.MarkdownProcessor;

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

    public void saveBlogPost(BlogPost blogPost)
    {
        if (blogPost.isNew())
        {

        }
        else
        {
            String sql = "update blogpost set title = ?, summary = ?, content = ? where id = ?";
            jdbcTemplate.update(sql,
                    new Object[] {
                            blogPost.getTitle(), blogPost.getSummary(), blogPost.getContent(), blogPost.getId()
                    });
        }
    }

}

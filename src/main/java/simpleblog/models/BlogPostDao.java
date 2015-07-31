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
    private SessionFactory sessionFactory;

    @Autowired
    private MarkdownProcessor mdProcessor;

    public List<BlogPost> getRecentPosts()
    {
        String hql = "from BlogPost p order by p.created desc";

        Session session = null;

        try
        {
            session = sessionFactory.openSession();

            List<BlogPost> blogPostList = session.createQuery(hql).setMaxResults(5).list();

            for (BlogPost blogPost : blogPostList)
            {
                blogPost.setContentHtml(mdProcessor.getHtml(blogPost.getContent()));
                blogPost.setSummaryHtml(mdProcessor.getHtml(blogPost.getSummary()));
            }

            return blogPostList;
        }
        finally {
            if (session != null) session.close();
        }
    }

    public BlogPost getBlogPost(int id)
    {
        String hql = "from BlogPost p where p.id = :id";

        Session session = null;

        try
        {
            session = sessionFactory.openSession();

            BlogPost blogPost = (BlogPost) session.createQuery(hql).setInteger("id", id).uniqueResult();

            blogPost.setContentHtml(mdProcessor.getHtml(blogPost.getContent()));
            blogPost.setSummaryHtml(mdProcessor.getHtml(blogPost.getSummary()));

            return blogPost;
        }
        finally {
            if (session != null) session.close();
        }
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

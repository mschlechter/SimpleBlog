package simpleblog.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleblog.models.BlogPost;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by marc on 31/07/15.
 */
@Service
@Transactional
public class BlogPostService {

    @Autowired
    private SessionFactory sessionFactory;

    public List<BlogPost> getRecentPosts()
    {
        return sessionFactory.getCurrentSession()
                .createQuery("from BlogPost p order by p.created desc")
                .setMaxResults(5)
                .list();
    }

    public BlogPost getBlogPost(int id)
    {
        return (BlogPost) sessionFactory.getCurrentSession()
                .createQuery("from BlogPost p where p.id = :id")
                .setInteger("id", id)
                .uniqueResult();
    }

    public void saveBlogPost(BlogPost blogPost)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(blogPost);
        session.flush();
    }

    public void updateBlogPost(BlogPost blogPost)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(blogPost);
        session.flush();
    }
}

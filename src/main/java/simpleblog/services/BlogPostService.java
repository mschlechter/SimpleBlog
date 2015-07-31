package simpleblog.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleblog.models.BlogPost;

import java.util.List;

/**
 * Created by marc on 31/07/15.
 */
@Service
public class BlogPostService {

    @Autowired
    private SessionFactory sessionFactory;

    public List<BlogPost> getRecentPosts()
    {
        String hql = "from BlogPost p order by p.created desc";

        Session session = null;

        try
        {
            session = sessionFactory.openSession();
            return session.createQuery(hql).setMaxResults(5).list();
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
            return (BlogPost) session.createQuery(hql).setInteger("id", id).uniqueResult();
        }
        finally {
            if (session != null) session.close();
        }
    }

    public void saveBlogPost(BlogPost blogPost)
    {
        Session session = null;

        try
        {
            session = sessionFactory.openSession();
            session.save(blogPost);
            session.flush();
        }
        finally {
            if (session != null) session.close();
        }
    }

    public void updateBlogPost(BlogPost blogPost)
    {
        Session session = null;

        try
        {
            session = sessionFactory.openSession();
            session.update(blogPost);
            session.flush();
        }
        finally {
            if (session != null) session.close();
        }
    }
}

package simpleblog.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by marc on 25/07/15.
 */
@Repository
public class BlogUserDao
{
    @Autowired
    private SessionFactory sessionFactory;

    public BlogUser getUserByName(String username)
    {
        String hql = "from BlogUser u where u.username = :username";

        Session session = null;

        try {
            session = sessionFactory.openSession();

            BlogUser user = (BlogUser) session.createQuery(hql).setString("username", username).uniqueResult();
            return user;
        }
        finally {
            if (session != null) session.close();
        }
    }

}

package simpleblog.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleblog.models.BlogUser;

/**
 * Created by marc on 31/07/15.
 */
@Service
public class BlogUserService {

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

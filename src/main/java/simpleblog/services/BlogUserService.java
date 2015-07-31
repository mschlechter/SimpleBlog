package simpleblog.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleblog.models.BlogUser;

import javax.transaction.Transactional;

/**
 * Created by marc on 31/07/15.
 */
@Service
@Transactional
public class BlogUserService {

    @Autowired
    private SessionFactory sessionFactory;

    public BlogUser getUserByName(String username)
    {
        return (BlogUser) sessionFactory.getCurrentSession()
                .createQuery("from BlogUser u where u.username = :username")
                .setString("username", username)
                .uniqueResult();
    }

}

package simpleblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import simpleblog.config.SimpleBlogConfig;
import simpleblog.domain.BlogPost;
import simpleblog.domain.BlogPostDao;

import java.util.List;

/**
 * Created by marc on 26/07/15.
 */
@Controller
public class ArchiveController
{
    @Autowired
    private SimpleBlogConfig blogConfig;

    @Autowired
    private BlogPostDao blogPostDao;

    @RequestMapping(value="/archive", method = RequestMethod.GET)
    public ModelAndView home()
    {
        List<BlogPost> blogPostList = blogPostDao.getBlogPostSummary();

        ModelAndView mav = new ModelAndView("archive");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPosts", blogPostList);

        return mav;
    }
}

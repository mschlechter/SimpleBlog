package simpleblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import simpleblog.config.SimpleBlogConfig;
import simpleblog.domain.BlogPost;
import simpleblog.domain.BlogPostDao;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SimpleBlogConfig blogConfig;

    @Autowired
    private Environment env;

    @Autowired
    private BlogPostDao blogPostDao;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("blogConfig", blogConfig);

        List<BlogPost> blogPostList = blogPostDao.getRecentPosts();
        mav.addObject("blogPosts", blogPostList);

        return mav;
    }

    @RequestMapping(value="/test", method = RequestMethod.GET)
    @ResponseBody
    public String test()
    {
        return "blog title = " + blogConfig.getBlogTitle();
    }

}
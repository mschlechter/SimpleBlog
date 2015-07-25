package simpleblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import simpleblog.config.SimpleBlogConfig;
import simpleblog.domain.BlogPost;
import simpleblog.domain.BlogPostDao;

import java.util.List;

/**
 * Created by marc on 12/07/15.
 */
@Controller
public class BlogPostController
{
    @Autowired
    private SimpleBlogConfig blogConfig;

    @Autowired
    private BlogPostDao blogPostDao;

    @RequestMapping(value="/post/{id}", method = RequestMethod.GET)
    public ModelAndView getBlogPostById(@PathVariable("id") int id)
    {
        BlogPost blogPost = blogPostDao.getBlogPost(id);

        ModelAndView mav = new ModelAndView("blogpost");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPost", blogPost);

        return mav;
    }

    @RequestMapping(value="/post/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getBlogPostByIdEdit(@PathVariable("id") int id)
    {
        BlogPost blogPost = blogPostDao.getBlogPost(id);

        ModelAndView mav = new ModelAndView("blogpostedit");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPost", blogPost);

        return mav;
    }

    @RequestMapping(value="/post/save", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(@ModelAttribute("blogPost") BlogPost blogPost)
    {
        blogPostDao.saveBlogPost(blogPost);




        /*
        BlogPost blogPost = blogPostDao.getBlogPost(id);

        ModelAndView mav = new ModelAndView("blogpostedit");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPost", blogPost);

        return mav;*/


        return new ModelAndView("redirect:/");

    }

}

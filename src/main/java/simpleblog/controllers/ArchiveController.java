package simpleblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import simpleblog.config.SimpleBlogConfig;
import simpleblog.models.BlogPost;
import simpleblog.models.BlogPostDao;
import simpleblog.services.BlogPostService;
import simpleblog.viewmodels.BlogPostEditViewModel;
import simpleblog.viewmodels.BlogPostSearchViewModel;

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

    @Autowired
    private BlogPostService blogPostService;

    @RequestMapping(value="/archive", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView home(@ModelAttribute("searchModel") BlogPostSearchViewModel blogPostSearchViewModel)
    {
        List<BlogPost> blogPostList = blogPostService.searchBlogPosts(blogPostSearchViewModel.getSearchText());

        ModelAndView mav = new ModelAndView("archive");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPosts", blogPostList);

        return mav;
    }

}

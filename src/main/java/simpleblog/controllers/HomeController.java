package simpleblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import simpleblog.config.SimpleBlogConfig;
import simpleblog.models.BlogPost;
import simpleblog.services.BlogPostService;
import simpleblog.services.MarkdownProcessor;
import simpleblog.viewmodels.BlogPostViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SimpleBlogConfig blogConfig;

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private MarkdownProcessor mdProcessor;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        List<BlogPost> blogPosts = blogPostService.getRecentPosts();

        List<BlogPostViewModel> blogPostViewModels = new ArrayList<BlogPostViewModel>();

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        for (BlogPost blogPost : blogPosts)
        {
            BlogPostViewModel blogPostViewModel = new BlogPostViewModel();
            blogPostViewModel.setId(blogPost.getId());
            blogPostViewModel.setTitle(blogPost.getTitle());
            blogPostViewModel.setSummaryHtml(mdProcessor.getHtml(blogPost.getSummary()));
            blogPostViewModel.setContentHtml(mdProcessor.getHtml(blogPost.getContent()));

            if (blogPost.getCreated() == null)
            {
                blogPostViewModel.setFormattedDate("unknown");
            }
            else
            {
                blogPostViewModel.setFormattedDate(format.format(blogPost.getCreated()));
            }

            blogPostViewModel.setAuthorName(blogPost.getAuthor().getFriendlyName());
            blogPostViewModels.add(blogPostViewModel);
        }

        ModelAndView mav = new ModelAndView("home");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPosts", blogPostViewModels);

        return mav;
    }

}
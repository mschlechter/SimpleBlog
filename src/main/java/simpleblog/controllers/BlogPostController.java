package simpleblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import simpleblog.config.SimpleBlogConfig;
import simpleblog.models.BlogPost;
import simpleblog.models.BlogPostDao;
import simpleblog.services.BlogPostService;
import simpleblog.services.MarkdownProcessor;
import simpleblog.viewmodels.BlogPostViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private MarkdownProcessor mdProcessor;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private BlogPostViewModel createBlogPostViewModel(BlogPost blogPost)
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
            blogPostViewModel.setFormattedDate(simpleDateFormat.format(blogPost.getCreated()));
        }

        blogPostViewModel.setAuthorName(blogPost.getAuthor().getFriendlyName());
        return blogPostViewModel;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        List<BlogPost> blogPosts = blogPostService.getRecentPosts();
        List<BlogPostViewModel> blogPostViewModels = new ArrayList<BlogPostViewModel>();

        for (BlogPost blogPost : blogPosts)
        {
            BlogPostViewModel blogPostViewModel = createBlogPostViewModel(blogPost);
            blogPostViewModels.add(blogPostViewModel);
        }

        ModelAndView mav = new ModelAndView("home");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPosts", blogPostViewModels);

        return mav;
    }

    @RequestMapping(value="/post/{id}", method = RequestMethod.GET)
    public ModelAndView getBlogPostById(@PathVariable("id") int id)
    {
        BlogPost blogPost = blogPostService.getBlogPost(id);
        BlogPostViewModel blogPostViewModel = createBlogPostViewModel(blogPost);

        ModelAndView mav = new ModelAndView("blogpost");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPost", blogPostViewModel);

        return mav;
    }

    @RequestMapping(value="/post/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getBlogPostByIdEdit(@PathVariable("id") int id)
    {
        BlogPost blogPost;

        if (id > 0) {
            blogPost = blogPostDao.getBlogPost(id);
        } else {
            blogPost = new BlogPost();
        }

        ModelAndView mav = new ModelAndView("blogpostedit");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPost", blogPost);

        return mav;
    }

    @RequestMapping(value="/post/save", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(@ModelAttribute("blogPost") BlogPost blogPost)
    {
        blogPostDao.saveBlogPost(blogPost);

        return new ModelAndView("redirect:/");
    }

}

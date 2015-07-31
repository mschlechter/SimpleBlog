package simpleblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import simpleblog.config.SimpleBlogConfig;
import simpleblog.models.BlogPost;
import simpleblog.models.BlogUser;
import simpleblog.services.BlogPostService;
import simpleblog.services.BlogUserService;
import simpleblog.services.CustomUserDetails;
import simpleblog.services.MarkdownProcessor;
import simpleblog.viewmodels.BlogPostEditViewModel;
import simpleblog.viewmodels.BlogPostViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private BlogPostService blogPostService;

    @Autowired
    private BlogUserService blogUserService;

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

    private BlogPostEditViewModel createBlogPostEditViewModel(BlogPost blogPost)
    {
        BlogPostEditViewModel blogPostEditViewModel = new BlogPostEditViewModel();
        blogPostEditViewModel.setId(blogPost.getId());
        blogPostEditViewModel.setTitle(blogPost.getTitle());
        blogPostEditViewModel.setSummary(blogPost.getSummary());
        blogPostEditViewModel.setContent(blogPost.getContent());
        return blogPostEditViewModel;
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
        BlogPostEditViewModel blogPostEditViewModel;

        if (id > 0) {
            BlogPost blogPost = blogPostService.getBlogPost(id);
            blogPostEditViewModel = createBlogPostEditViewModel(blogPost);
        } else {
            blogPostEditViewModel = new BlogPostEditViewModel();
        }

        ModelAndView mav = new ModelAndView("blogpostedit");
        mav.addObject("blogConfig", blogConfig);
        mav.addObject("blogPost", blogPostEditViewModel);

        return mav;
    }

    @RequestMapping(value="/post/save", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(@ModelAttribute("blogPost") BlogPostEditViewModel blogPostEditViewModel)
    {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BlogUser blogUser = blogUserService.getUserByName(customUserDetails.getUsername());

        if (blogPostEditViewModel.getId() == 0)
        {
            // new
            BlogPost blogPost = new BlogPost();
            blogPost.setTitle(blogPostEditViewModel.getTitle());
            blogPost.setSummary(blogPostEditViewModel.getSummary());
            blogPost.setContent(blogPostEditViewModel.getContent());
            blogPost.setCreated(new Date());
            blogPost.setAuthor(blogUser);

            blogPostService.saveBlogPost(blogPost);
        }
        else
        {
            // update
            BlogPost blogPost = blogPostService.getBlogPost(blogPostEditViewModel.getId());
            blogPost.setTitle(blogPostEditViewModel.getTitle());
            blogPost.setSummary(blogPostEditViewModel.getSummary());
            blogPost.setContent(blogPostEditViewModel.getContent());
            blogPost.setCreated(new Date());
            blogPost.setAuthor(blogUser);

            blogPostService.updateBlogPost(blogPost);
        }


        return new ModelAndView("redirect:/");
    }

}

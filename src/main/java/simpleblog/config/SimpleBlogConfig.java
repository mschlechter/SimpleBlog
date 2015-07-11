package simpleblog.config;

import org.springframework.beans.factory.annotation.Value;
import simpleblog.config.ISimpleBlogConfig;

/**
 * Created by marc on 11/07/15.
 */
public class SimpleBlogConfig implements ISimpleBlogConfig {

    @Value("${simpleblog.title}")
    private String blogTitle;

    @Value("${simpleblog.subtitle}")
    private String blogSubTitle;

    public String getBlogTitle()
    {
        return blogTitle;
    }

    public String getBlogSubTitle()
    {
        return blogSubTitle;
    }

    public SimpleBlogConfig()
    {
        blogTitle = "SimpleBlog for somebody";
    }


}

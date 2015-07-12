package simpleblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by marc on 11/07/15.
 */
@Component
public class SimpleBlogConfig {

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

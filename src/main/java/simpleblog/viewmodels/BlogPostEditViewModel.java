package simpleblog.viewmodels;

import simpleblog.models.BlogPost;

/**
 * Created by marc on 31/07/15.
 */
public class BlogPostEditViewModel {

    private int id;
    private String title;
    private String summary;
    private String content;

    public BlogPostEditViewModel()
    {
        id = -1;
    }

    public BlogPostEditViewModel(BlogPost blogPost)
    {
        this.id = blogPost.getId();
        this.title = blogPost.getTitle();
        this.summary = blogPost.getSummary();
        this.content = blogPost.getContent();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

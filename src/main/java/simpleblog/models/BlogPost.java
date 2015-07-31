package simpleblog.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marc on 11/07/15.
 */
@Entity
public class BlogPost {

    @Id
    private int id;
    private String title;
    private Date created;
    private String content;
    private String summary;

    @Transient
    private String contentHtml;

    @Transient
    private String summaryHtml;

    @ManyToOne(fetch = FetchType.EAGER)
    private BlogUser author;


    public String getFormattedDate()
    {
        if (created == null) return "unknown";

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(created);
    }

    public boolean isNew()
    {
        return id <= 0;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public String getSummaryHtml() {
        return summaryHtml;
    }

    public void setSummaryHtml(String summaryHtml) {
        this.summaryHtml = summaryHtml;
    }

    public BlogUser getAuthor() {
        return author;
    }

    public void setAuthor(BlogUser author) {
        this.author = author;
    }
}

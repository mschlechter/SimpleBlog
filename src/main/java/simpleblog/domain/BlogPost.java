package simpleblog.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marc on 11/07/15.
 */
public class BlogPost {

    private int id;
    private String title;
    private Date created;
    private String contentmd;
    private String contenthtml;

    public String getFormattedDate()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(created);
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

    public String getContentmd() {
        return contentmd;
    }

    public void setContentmd(String contentmd) {
        this.contentmd = contentmd;
    }

    public String getContenthtml() {
        return contenthtml;
    }

    public void setContenthtml(String contenthtml) {
        this.contenthtml = contenthtml;
    }
}

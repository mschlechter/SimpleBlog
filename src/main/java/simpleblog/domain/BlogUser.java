package simpleblog.domain;

/**
 * Created by marc on 25/07/15.
 */
public class BlogUser
{
    private int id;
    private String username;
    private String password;
    private String friendlyname;
    private boolean isadmin;

    public int getRole()
    {
        return isadmin ? 2 : 1;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFriendlyname() {
        return friendlyname;
    }

    public void setFriendlyname(String friendlyname) {
        this.friendlyname = friendlyname;
    }

    public boolean isadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
}

package simpleblog.viewmodels;

/**
 * Created by marc on 1-8-15.
 */
public class BlogPostSearchViewModel {

    private String searchText;

    public BlogPostSearchViewModel()
    {
        searchText = "";
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}

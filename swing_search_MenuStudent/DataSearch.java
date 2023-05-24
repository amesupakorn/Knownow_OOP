package swing_search_MenuStudent;

import Option_Login.Students;


public class DataSearch implements Students{
    
    private String text;
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DataSearch(String text) {
        this.text = text;
    }

    public DataSearch() {
    }
}

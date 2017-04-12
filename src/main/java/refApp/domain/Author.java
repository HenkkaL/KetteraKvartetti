package refApp.domain;

public class Author {

    private String name;

    public Author(String authorName) {
        this.name = authorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

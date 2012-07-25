package tw.book;

public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.name.equals(book.getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
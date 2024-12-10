import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Student {
    private final List<Book> books;
    private String name;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = new ArrayList<>(books);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Студент: " + name + "\nКниги: " + books;
    }

}

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class MainSecond {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Наташа", List.of(
                        new Book("Учебник 1",  400, 1998),
                        new Book("Учебник 2",  369,1999 ),
                        new Book("Учебник 3",  250, 2010),
                        new Book("Рабочая тетрадь 1",  150, 2010),
                        new Book("Рабочая тетрадь 2", 180, 2013)
                )),
                new Student("Кирилл", List.of(
                        new Book("Учебник 1",  400, 1998),
                        new Book("Учебник 2",  369,1999),
                        new Book("Учебник 4",  310, 2008),
                        new Book("Учебник 5",  320, 2010),
                        new Book("Словарик",  1400, 1960),
                        new Book("Рабочая тетрадь 1",  150, 2010),
                        new Book("Рабочая тетрадь 2",  180, 2013)
                ))
        );

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() >= 2000)
                .limit(3)
                .map(Book::getYear)
                .map(Optional::of)
                .forEach(o -> o.ifPresentOrElse(System.out::println, () -> System.out.println("Книга не найдена")));

    }

}
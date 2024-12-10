import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
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
                .map(Student::getName)
                .forEach(System.out::println);
        System.out.println();

        students.forEach(student -> {
            System.out.println("Книги студента " + student.getName() + ":");
            student.getBooks().stream()
                    .map(Book::getTitle)
                    .forEach(System.out::println);
            System.out.println();
        });
        System.out.println("\nВсе книги");

                students.stream()
                .flatMap(student -> student.getBooks().stream())
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("\nСортировка по страницам");
                students.stream()
                .flatMap(student -> student.getBooks().stream())
                .sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
                .collect(Collectors.toList())
                 .forEach(System.out::println);


        System.out.println("\nУникальные книги");
        students.stream()
                .flatMap(student -> student.getBooks().stream())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("\nКниги после 2000 года");



                students.stream()
                        .flatMap(student -> student.getBooks().stream())
                        .filter(book -> book.getYear() >= 2000)
                        .distinct()
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
        System.out.println("\nГоды выпуска книг");

                students.stream()
                        .flatMap(student -> student.getBooks().stream())
                        .map(Book::getYear)
                        .forEach(System.out::println);

        System.out.println("\nПервые 3 книги:");
                students.stream()
                        .flatMap(student -> student.getBooks().stream())
                        .distinct()
                        .limit(3)
                        .forEach(System.out::println);


        Optional<Book> Book1984 = students.stream()
                .flatMap(student -> student.getBooks().stream())
                .filter(book -> book.getTitle().equals("Словарик"))
                .findFirst();

        String publicationYearMessage = Book1984
                .map(Book::getYear)
                .map(String::valueOf)
                .orElse("\nКнига не найдена");

        System.out.println("\nГод выпуска книги " + "Словарик" + ": " + publicationYearMessage);





    }

}
import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private final List<Book> store = new ArrayList<>();

    public void addBook(final Book book) {
        store.add(book);
    }

    public List<Book> findBooks(final Date from, final Date to) {
        Calendar end = Calendar.getInstance();

        end.setTime(to);
        end.roll(Calendar.YEAR, 1);

        return store.stream().filter(book -> {
            return from.before(book.getPublished()) && end.getTime().after(book.getPublished());
        }).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
    }

    public int HowManyBooks(String author) {
        int result = 0;
        for (Book a : store) {
            String author_a = a.getAuthor();
            if (author_a.equals(author)) {
                result++;
            }
        }
        return result;
    }
}
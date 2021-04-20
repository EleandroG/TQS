import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LibrarySteps {
    Library library = new Library();

    int result_2;

    @Given("(a|another) book with the title {string}, written by {string}")
    public void addNewBook(final String title, final String author) {
        Book book = new Book(title, author);
        library.addBook(book);
    }

    @When("the customer searches how many books does {string} have")
    public void seachNumberOfBooks(final String author) {
        result_2 = library.HowManyBooks(author);
    }

    @Then("{int} books should be showned")
    public void verifyAmountOfBooksFoundByAuthor(final int booksFound) {
        assertThat(result_2, equalTo(booksFound));
    }
}

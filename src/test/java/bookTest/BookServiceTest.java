package bookTest;

import exceptii.StatusException;
import model.Book;
import model.Student;
import org.junit.jupiter.api.Test;
import repository.BookRepo;
import repository.StudentRepo;
import services.BookService;
import services.StudentService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    BookRepo bookRepo;
    StudentRepo studentRepo;

    private BookServiceTest() {
        bookRepo = new BookRepo("online_shop_test");
        studentRepo = new StudentRepo("online_shop_test");
    }

    @Test
    public void erase() {
        bookRepo.eraseAll();
        studentRepo.eraseAll();
    }

    @Test
    public void bookAddTest() throws StatusException {
        BookService bookService = new BookService(bookRepo);
        StudentRepo studentRepo2 = studentRepo;
        Student x = new Student("Flore", "Denis", 14, "parola1", "denis@yahoo.com");
        studentRepo2.insert(x);
        Book l = new Book(1, "Thor", LocalDate.of(2011, 12, 12));
        bookService.addBook(l);
        assertEquals("Thor", bookService.findByName("Thor", 1).getBook_name());
        bookRepo.eraseAll();
        studentRepo.eraseAll();
    }

    @Test
    public void bookAddTestThrow() throws StatusException {
        BookService bookService = new BookService(bookRepo);
        StudentRepo studentRepo2 = studentRepo;
        Student x = new Student("Flore", "Denis", 14, "parola1", "denis@yahoo.com");
        studentRepo2.insert(x);
        Book l = new Book(1, "Thor", LocalDate.of(2011, 12, 12));
        bookService.addBook(l);
        assertThrows(StatusException.class, () -> bookService.addBook(l));
        bookRepo.eraseAll();
        studentRepo.eraseAll();
    }


    @Test
    public void bookRemoveTest() throws StatusException {
        BookService bookService = new BookService(bookRepo);
        StudentRepo studentRepo2 = studentRepo;
        Student x = new Student("Flore", "Denis", 14, "parola1", "denis@yahoo.com");
        studentRepo2.insert(x);
        Book l = new Book(1, "Thor", LocalDate.of(2011, 12, 12));
        bookService.addBook(l);
        bookService.removeBook("Thor", 1);
        assertEquals(null, bookService.findByName("Thor", 1));
        bookRepo.eraseAll();
        studentRepo.eraseAll();
    }

    @Test
    public void removeThrow() throws StatusException {
        BookService bookService = new BookService(bookRepo);
        assertThrows(StatusException.class, () -> bookService.removeBook("Ionut Florea", 1));
        bookRepo.eraseAll();
        studentRepo.eraseAll();
    }

    @Test
    public void updateBook() throws StatusException {
        StudentRepo studentRepo2 = studentRepo;
        Student x = new Student("Flore", "Denis", 14, "parola1", "denis@yahoo.com");
        studentRepo2.insert(x);
        BookService bookService = new BookService(bookRepo);
        Book l = new Book(1, "Thor", LocalDate.of(2011, 12, 12));
        bookService.addBook(l);
        bookService.updateBookName("Thor", 1, "Thor 2");
        assertEquals("Thor 2", bookService.findByName("Thor 2", 1).getBook_name());
        bookRepo.eraseAll();
        studentRepo.eraseAll();
    }

    @Test
    public void updateThrow() throws StatusException {
        BookService bookService = new BookService(bookRepo);
        assertThrows(StatusException.class, () -> bookService.updateBookName("Manuela", 1, "denis"));
    }

    @Test
    public void test() throws StatusException {
        StudentRepo studentRepo2 = studentRepo;
        Student x = new Student("Flore", "Denis", 14, "parola1", "denis@yahoo.com");
        studentRepo2.insert(x);
        BookService bookService = new BookService(bookRepo);
        Book l = new Book(1, "Thor", LocalDate.of(2011, 12, 12));
        Book l1 = new Book(1, "Thor 2", LocalDate.of(2011, 12, 12));
        Book l2 = new Book(1, "Thor 3", LocalDate.of(2011, 12, 12));
        Book l3 = new Book(1, "Thor 4", LocalDate.of(2011, 12, 12));
        bookService.addBook(l);
        bookService.addBook(l1);
        bookService.addBook(l2);
        bookService.addBook(l3);
        bookService.booksAvailable();
        bookRepo.eraseAll();

    }
}
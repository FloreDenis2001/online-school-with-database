package bookTest;

import model.Book;
import model.Student;
import org.junit.jupiter.api.Test;
import repository.BookRepo;
import repository.StudentRepo;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BookRepoTest {

    private BookRepo bookRepo2;

    public BookRepoTest() {
        this.bookRepo2 = new BookRepo("online_shop_test");
    }

    @Test
    public void clearAllTest() {
        BookRepo bookRepo = bookRepo2;
        bookRepo.eraseAll();
    }


    @Test
    public void insertTest() {
        StudentRepo studentRepo = new StudentRepo("online_shop_test");
        Student x = new Student("Denis", "Gratian", 25, "denis2103", "adrian@yahoo.com");
        studentRepo.insert(x);
        Book t = new Book(1, "Marvin", LocalDate.of(2012, 10, 12));
        BookRepo bookRepo = bookRepo2;
        bookRepo.insert(t);
        assertEquals("Marvin", bookRepo.findBook(t.getBook_name()).getBook_name());
        bookRepo.eraseAll();
        studentRepo.eraseAll();
    }

    @Test
    public void deleteTest() {
        StudentRepo studentRepo=new StudentRepo("online_shop_test");
        Student x = new Student("Halau","Marian",21,"marian123","marian@yahoo.com");
        studentRepo.insert(x);
        Book t = new Book(1,"Thor",LocalDate.of(2021,11,6));
        BookRepo bookRepo = bookRepo2;
        bookRepo.insert(t);
        bookRepo.delete("Thor");
        assertEquals(null,bookRepo.findBook(t.getBook_name()));
        studentRepo.eraseAll();
        bookRepo.eraseAll();
    }

    @Test
    public void updateTest() {
        StudentRepo studentRepo=new StudentRepo("online_shop_test");
        Student x = new Student("Halau","Marian",21,"marian123","marian@yahoo.com");
        studentRepo.insert(x);
        Book t = new Book(1,"Thor",LocalDate.of(2021,11,6));
        BookRepo bookRepo = bookRepo2;
        bookRepo.insert(t);

        bookRepo.update(t.getBook_name(), "Harry");

        assertEquals("Harry",bookRepo.findBook("Harry").getBook_name());

        studentRepo.eraseAll();
        bookRepo.eraseAll();

    }

    @Test
    public void allBookTest() {
        BookRepo bookRepo = new BookRepo("online_shop_test");
        List<Book> e = bookRepo.allBook();
        for (Book t : e) {
            System.out.println(t);
        }
    }
}
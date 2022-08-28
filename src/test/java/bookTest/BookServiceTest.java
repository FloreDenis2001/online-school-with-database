package bookTest;

import exceptii.StatusException;
import model.Book;
import org.junit.jupiter.api.Test;
import services.BookService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
@Test
    public void findTest(){
    BookService bookService=new BookService();
    assertEquals("Nina Frisk",bookService.findById(3).getBook_name());
}

@Test
    public void bookAddTest() throws StatusException {
    BookService bookService=new BookService();
    Book l=new Book(5,"Thor", LocalDate.of(2011,12,12));
    bookService.addBook(l);
    assertEquals("Thor",bookService.findById(23).getBook_name());
}

//@Test
//    public void bookAddTest2() throws StatusException{
//    BookService bookService=new BookService();
//    assertThrows(StatusException.class,()->bookService.addBook(new Book(5,"Thor", LocalDate.of(2011,12,12))));
//}

    @Test
    public void bookRemoveTest() throws StatusException{
    BookService bookService=new BookService();
    bookService.removeBook(5);
    assertEquals(null,bookService.findById(5));
    }

    @Test
    public void removeThrow()throws StatusException{
    BookService bookService=new BookService();
    assertThrows(StatusException.class,()->bookService.removeBook(100));
    }

    @Test
    public void updateBook() throws  StatusException{
    BookService bookService=new BookService();
    bookService.updateBookName(7,"Flore Denis");
    assertEquals("Flore Denis",bookService.findById(7).getBook_name());
    }

    @Test
    public void updateThrow() throws  StatusException{
    BookService bookService=new BookService();
    assertThrows(StatusException.class,()->bookService.updateBookName(1000,"denis"));
    }
}
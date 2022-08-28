package bookTest;

import model.Book;
import org.junit.jupiter.api.Test;
import repository.BookRepo;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookRepoTest {
    @Test
    public void insertTest(){
        Book t =new Book(3,"Ionut Florea", LocalDate.of(2012,10,12));
        BookRepo bookRepo=new BookRepo();
        bookRepo.insert(t);
    }

    @Test
    public void deleteTest(){
        BookRepo bookRepo=new BookRepo();
        bookRepo.delete("Thor");
    }

    @Test
    public void updateTest(){
        BookRepo bookRepo=new BookRepo();
        bookRepo.update("Momo","Harry Poter");
    }

   @Test
    public void allBookTest(){
        BookRepo bookRepo=new BookRepo();
        List<Book> e =bookRepo.allBook();
        for(Book t : e ){
            System.out.println(t);
        }
   }
}
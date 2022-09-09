package services;

import exceptii.StatusException;
import model.Book;
import repository.BookRepo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class BookService {

    BookRepo bookRepo;

    public BookService(BookRepo bookRepow) {
        this.bookRepo = bookRepow;
    }

    public Book findByName(String bookName,int studentId) {
        List<Book> e = bookRepo.allBook();
        for (Book t : e)
            if (t.getBook_name().compareTo(bookName) == 0 && t.getStudent_id()==studentId) {
                return t;
            }

        return null;
    }

    public void addBook(Book book) throws StatusException {
        Book t = findByName(book.getBook_name(),book.getStudent_id());
        if (t == null) {
            bookRepo.insert(book);
        } else {
            throw new StatusException("Cartea Exista Deja ! ");
        }
    }

    public void removeBook(String bookName,int studentId) throws StatusException {
        Book t = findByName(bookName,studentId);
        if (t != null) {
            bookRepo.delete(t.getBook_name());
        } else {
            throw new StatusException("Cartea nu exista ! ");
        }
    }

    public void updateBookName(String bookName,int studentId, String updateName) throws StatusException {
        Book t = findByName(bookName,studentId);
        if (t != null) {
            bookRepo.update(t.getBook_name(), updateName);
        } else {
            throw new StatusException("Cartea nu exista");
        }
    }


    public List<Book> bookList() {
        List<Book> books = bookRepo.allBook();
        List<Book> newList= new ArrayList<>();
         for(Book t : books){
             if(!newList.contains(t.getBook_name())){
                 newList.add(t);
             }
         }
         return newList;
    }

    public void booksAvailable() {
        BookService bookService=new BookService(bookRepo);
        List<Book> bookList=bookService.bookList();
        List<String> bookNames=new ArrayList<>();
        for(Book x :bookList)
            bookNames.add(x.getBook_name());

        List<String> booksWithoutDuplicates=new ArrayList<>();
        for(String x : bookNames)
            if(!booksWithoutDuplicates.contains(x)){
                booksWithoutDuplicates.add(x);
            }


        for(String x : booksWithoutDuplicates)
            System.out.println(x);

    }

}
package services;

import exceptii.StatusException;
import model.Book;
import repository.BookRepo;

import java.util.List;

public class BookService {

    BookRepo bookRepo;

    public BookService() {
        bookRepo = new BookRepo();
    }

    public Book findById(int id) {
        List<Book> e = bookRepo.allBook();
        for (Book t : e) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void addBook(Book book) throws StatusException {
        Book t = findById(book.getId());
        if (t == null) {
            bookRepo.insert(book);
        } else {
            throw new StatusException("Cartea Exista Deja ! ");
        }
    }

    public void removeBook(int id) throws StatusException {
        Book t = findById(id);
        if (t != null) {
            bookRepo.deleteById(id);
        } else {
            throw new StatusException("Cartea nu exista ! ");
        }
    }

    public void updateBookName(int id, String new_name) throws StatusException {
        Book t = findById(id);
        if (t != null) {
            bookRepo.update(t.getBook_name(), new_name);
        } else {
            throw new StatusException("Cartea nu exista");
        }
    }

}
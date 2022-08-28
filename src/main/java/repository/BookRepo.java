package repository;

import model.Book;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRepo extends Repository {

    @Override
    public void insert(Object x) {
        Book t = (Book) x;
        String insert = "insert into book (student_id,book_name,create_at) values(" + String.format("%d,'%s','%s'", t.getStudent_id(), t.getBook_name(), t.getCreate_at())+")";
        executeStatement(insert);
    }

    @Override
    public void delete(String bookName) {
         String delete =String.format("delete from book where book_name='%s' ",bookName);
         executeStatement(delete);
    }

    public void deleteById(int bookId) {
         String delete =String.format("delete from book where id=%d ",bookId);
         executeStatement(delete);
    }


    public void update(String old_book_name, String updateBookName) {
        String update = String.format("update book set book_name='%s' where book_name='%s'",updateBookName,old_book_name);
        executeStatement(update);
    }

    public List<Book> allBook() {
        executeStatement("select * from book");
        List<Book> books = new ArrayList<>();


        try {
            ResultSet set= statement.getResultSet();

            while (set.next()){
                books.add(new Book(set.getInt(1),set.getInt(2),set.getString(3),set.getDate(4).toLocalDate()));
            }

            return books;


        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }
}

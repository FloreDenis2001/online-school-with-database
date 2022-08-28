package model;

import java.time.LocalDate;

public class Book implements Comparable<Book> {
    private int id;
    private int student_id;
    private String book_name;
    private LocalDate create_at;

    public Book(int id, int student_id, String book_name, LocalDate create_at) {
        this.id = id;
        this.student_id = student_id;
        this.book_name = book_name;
        this.create_at = create_at;
    }

    public Book(int student_id, String book_name, LocalDate create_at) {
        this.student_id = student_id;
        this.book_name = book_name;
        this.create_at = create_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        String text = "Id : " + this.id + "\n";
        text += "Student Id : " + this.student_id + "\n";
        text += "Book Name : " + this.book_name + "\n";
        text += "Create At : " + this.create_at + "\n";

        return text;
    }

    @Override
    public boolean equals(Object x) {
        Book t = (Book) x;
        return this.student_id == t.getStudent_id();
    }


    @Override
    public int compareTo(Book o) {
        if (this.student_id > o.getStudent_id()) {
            return 1;
        } else if (this.student_id < o.getStudent_id()) {
            return -1;
        } else {
            return 0;
        }
    }
}

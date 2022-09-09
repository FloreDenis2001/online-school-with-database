package StudentTest;

import exceptii.StatusException;
import model.Book;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.BookRepo;
import repository.StudentRepo;
import services.BookService;
import services.StudentService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private StudentRepo studentRepo;
    private BookRepo bookRepo;

    public StudentServiceTest() {
        studentRepo = new StudentRepo("online_shop_test");
        bookRepo = new BookRepo("online_shop_test");
    }

    @BeforeEach()
    public void setup() {
        studentRepo.eraseAll();
        bookRepo.eraseAll();
    }

    @Test
    public void addStudentTest() throws StatusException {
        StudentService studentService = new StudentService(studentRepo);
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        assertEquals(21, studentService.findByEmail(x.getEmail()).getAge());
        studentRepo.eraseAll();
    }

    @Test
    public void addThrowTest() throws StatusException {
        StudentService studentService = new StudentService(studentRepo);
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        Student y = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        assertThrows(StatusException.class, () -> studentService.addStudent(y));
        studentRepo.eraseAll();
    }

    @Test
    public void removeTest() throws StatusException {
        StudentService studentService = new StudentService(studentRepo);
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        studentService.remove(x.getEmail());
        assertEquals(null, studentService.findByEmail(x.getEmail()));
        studentRepo.eraseAll();
    }

    @Test
    public void removeTestThrow() throws StatusException {
        StudentService studentService = new StudentService(studentRepo);
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        assertThrows(StatusException.class, () -> studentService.remove("marian@yahoo.com"));
        studentRepo.eraseAll();
    }

    @Test
    public void updateTest() throws StatusException {
        StudentService studentService = new StudentService(studentRepo);
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        studentService.updatePassword(x.getEmail(), "parolanoua");
        assertEquals("parolanoua", studentService.findByEmail(x.getEmail()).getPassword());
        studentRepo.eraseAll();
    }

    @Test
    public void updateThrowTest() throws StatusException {
        StudentService studentService = new StudentService(studentRepo);
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        assertThrows(StatusException.class, () -> studentService.updatePassword("flr@yahoo.com", "parolanoua"));
        studentRepo.eraseAll();
    }

    @Test
    public void findByEmail() {
        StudentService studentService = new StudentService(new StudentRepo("online_school_db"));
        Student x = studentService.findByEmail("Beverie@gmail.com");
        assertEquals(21, x.getAge());
    }

    @Test
    public void studentbookTest() throws StatusException {
        StudentService studentService = new StudentService(studentRepo);
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        Student p = studentService.findByEmail("denisG@yahoo.com");
        BookService bookService = new BookService(new BookRepo("online_shop_test"));
        Book t = new Book(p.getId(), "Harry Poter", LocalDate.now());
        bookService.addBook(t);
        studentService.myBooks(p);

    }

    @Test
    public void verifyAccount() throws StatusException {
        StudentService studentService = new StudentService(studentRepo);
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        assertEquals(x, studentService.verifyAcc("denis2001", "denisG@yahoo.com"));
    }

    @Test
    public void verfyAccount2() throws StatusException {
        StudentService studentService = new StudentService(studentRepo);
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        assertEquals(null,studentService.verifyAcc("denis2001","denis@yahoo.com"));
    }


}
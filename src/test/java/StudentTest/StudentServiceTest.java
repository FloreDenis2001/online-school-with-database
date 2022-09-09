package StudentTest;

import exceptii.StatusException;
import model.Book;
import model.Student;
import org.junit.jupiter.api.Test;
import repository.StudentRepo;
import services.StudentService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private StudentRepo studentRepo;

    public StudentServiceTest() {
        studentRepo = new StudentRepo("online_shop_test");
    }

    @Test
    public void erase() {
        studentRepo.eraseAll();
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
    public void findByEmail(){
        StudentService studentService=new StudentService(new StudentRepo("online_school_db"));
        Student x = studentService.findByEmail("Beverie@gmail.com");
        assertEquals(21,x.getAge());
    }

    @Test
    public void studentbookTest()  {
        StudentService studentService = new StudentService(new StudentRepo("online_school_db"));
        Student x = studentService.findByEmail("Mel@gmail.com");
        studentService.myBooks(x);
    }

    @Test
    public void verifyAccount(){
        StudentService studentService=new StudentService(new StudentRepo("online_school_db"));
        Student x = studentService.verifyAcc("denisflore","floredenis907@yahoo.com");
        assertEquals(x,studentService.verifyAcc("denisflore","floredenis907@yahoo.com"));
    }
}
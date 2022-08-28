package StudentTest;

import exceptii.StatusException;
import model.Student;
import org.junit.jupiter.api.Test;
import services.StudentService;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void findTest() {
        StudentService studentService = new StudentService();
        assertEquals(20, studentService.findById(13).getAge());
    }

    @Test
    public void addStudentTest() throws StatusException {
        StudentService studentService = new StudentService();
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        studentService.addStudent(x);
        assertEquals("denisG@yahoo.com", studentService.findById(32).getEmail());
    }

    @Test
    public void addThrowTest() throws StatusException{
        StudentService studentService = new StudentService();
        Student x = new Student("Flore", "Denis", 21, "denis2001", "denisG@yahoo.com");
        assertThrows(StatusException.class,()->studentService.addStudent(x));
    }

    @Test
    public void removeStudentTest() throws StatusException {
        StudentService studentService = new StudentService();
        studentService.removeStudent(studentService.findById(14));
        assertEquals(null, studentService.findById(14));
    }

   @Test
    public void updateTest()throws StatusException{
        StudentService studentService=new StudentService();
        studentService.updatePassword(10,"denis2022");
        assertEquals("denis2022",studentService.findById(10).getPassword());
   }

   @Test
    public void updateThrowTest() throws StatusException{
       StudentService studentService=new StudentService();
       assertThrows(StatusException.class,()->studentService.updatePassword(100,"denis2022"));
   }

}
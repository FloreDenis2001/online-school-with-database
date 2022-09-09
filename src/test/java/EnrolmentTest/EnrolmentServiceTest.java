package EnrolmentTest;

import exceptii.StatusException;
import model.Course;
import model.Enrolment;
import model.Student;
import org.junit.jupiter.api.Test;
import repository.CourseRepo;
import repository.EnrolmentRepo;
import repository.StudentRepo;
import services.EnrolmentService;
import services.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EnrolmentServiceTest {
    EnrolmentRepo enrolmentRepo;
    CourseRepo courseRepo;
    StudentRepo studentRepo;

    private EnrolmentServiceTest() {
        enrolmentRepo = new EnrolmentRepo("online_shop_test");
        courseRepo = new CourseRepo("online_shop_test");
        studentRepo = new StudentRepo("online_shop_test");
    }

    @Test
    public void eraseTest() {
        enrolmentRepo.eraseAll();
        courseRepo.eraseAll();
        studentRepo.eraseAll();
    }

@Test
public void addEnrolThrow() throws StatusException{
    StudentRepo studentRepo2 = studentRepo;
    Student p = new Student("Flore", "Denis", 32, "parola1", "denis@gmail.com");
    studentRepo2.insert(p);

    CourseRepo courseRepo2 = courseRepo;
    Course x = new Course("sport", "fotbal");
    courseRepo2.insert(x);

    EnrolmentService enrolmentService = new EnrolmentService(enrolmentRepo);
    Enrolment t = new Enrolment(1, 1, LocalDate.of(2022, 8, 28));
    enrolmentService.addEnrolment(t);

    assertThrows(StatusException.class,()->enrolmentService.addEnrolment(t));
    eraseTest();

}
    @Test
    public void addEnrolTest() throws StatusException {
        StudentRepo studentRepo2 = studentRepo;
        Student p = new Student("Flore", "Denis", 32, "parola1", "denis@gmail.com");
        studentRepo2.insert(p);

        CourseRepo courseRepo2 = courseRepo;
        Course x = new Course("sport", "fotbal");
        courseRepo2.insert(x);

        EnrolmentService enrolmentService = new EnrolmentService(enrolmentRepo);
        Enrolment t = new Enrolment(1, 1, LocalDate.of(2022, 8, 28));
        enrolmentService.addEnrolment(t);


        assertEquals(1, enrolmentService.findByStudentId(1, 1).getCourseId());
        eraseTest();
    }
    @Test
    public void removeThrow() throws  StatusException{
        StudentRepo studentRepo2 = studentRepo;
        Student p = new Student("Flore", "Denis", 32, "parola1", "denis@gmail.com");
        studentRepo2.insert(p);

        CourseRepo courseRepo2 = courseRepo;
        Course x = new Course("sport", "fotbal");
        courseRepo2.insert(x);

        EnrolmentService enrolmentService=new EnrolmentService(enrolmentRepo);
        Enrolment t = new Enrolment(1, 1, LocalDate.of(2022, 8, 28));
        enrolmentService.addEnrolment(t);
        enrolmentService.removeEnrolment(1,1);
         assertThrows(StatusException.class,()->enrolmentService.removeEnrolment(t.getStudentId(),t.getCourseId()));
         eraseTest();
    }

    @Test
    public void removeEnrolTest() throws  StatusException{
        StudentRepo studentRepo2 = studentRepo;
        Student p = new Student("Flore", "Denis", 32, "parola1", "denis@gmail.com");
        studentRepo2.insert(p);

        CourseRepo courseRepo2 = courseRepo;
        Course x = new Course("sport", "fotbal");
        courseRepo2.insert(x);

        EnrolmentService enrolmentService=new EnrolmentService(enrolmentRepo);
        Enrolment t = new Enrolment(1, 1, LocalDate.of(2022, 8, 28));
        enrolmentService.addEnrolment(t);
        enrolmentService.removeEnrolment(1,1);
        assertEquals(null,enrolmentService.findByStudentId(1,1));
        eraseTest();
    }

    @Test
    public void updateEnrolemntTest() throws StatusException{
        StudentRepo studentRepo2 = studentRepo;
        Student p = new Student("Flore", "Denis", 32, "parola1", "denis@gmail.com");
        studentRepo2.insert(p);

        CourseRepo courseRepo2 = courseRepo;
        Course x = new Course(1,"sport", "fotbal");
        Course t = new Course(2,"sport", "golf");
        courseRepo2.insert(x);
        courseRepo2.insert(t);

        EnrolmentService enrolmentService=new EnrolmentService(enrolmentRepo);
        Enrolment l = new Enrolment(1, 1, LocalDate.of(2022, 8, 28));
        enrolmentService.addEnrolment(l);
        enrolmentService.updateEnrolemnt(1,1,2);
        assertEquals(2,enrolmentService.findByStudentId(1,2).getCourseId());
        eraseTest();
    }

    @Test
    public void updateThrow()throws StatusException{

        StudentRepo studentRepo2 = studentRepo;
        Student p = new Student("Flore", "Denis", 32, "parola1", "denis@gmail.com");
        studentRepo2.insert(p);

        CourseRepo courseRepo2 = courseRepo;
        Course x = new Course(1,"sport", "fotbal");
        Course t = new Course(2,"sport", "golf");
        courseRepo2.insert(x);
        courseRepo2.insert(t);

        EnrolmentService enrolmentService=new EnrolmentService(enrolmentRepo);
        Enrolment l = new Enrolment(1, 1, LocalDate.of(2022, 8, 28));
        enrolmentService.addEnrolment(l);
        assertThrows(StatusException.class,()->enrolmentService.updateEnrolemnt(1,5,8));
        eraseTest();
    }

    @Test
    public void listCourses() {
        StudentService studentService=new StudentService(new StudentRepo("online_school_db"));
        Student x = studentService.findByEmail("Beverie@gmail.com");
        EnrolmentService enrolmentService=new EnrolmentService(new EnrolmentRepo("online_school_db"));
        ArrayList<Integer> courses = enrolmentService.courseIds(x);
       for(Integer c:courses){
           System.out.println(c);
       }
    }

    @Test
    public void mycourses(){
        StudentService studentService=new StudentService(new StudentRepo("online_school_db"));
        Student x = studentService.findByEmail("Beverie@gmail.com");
        EnrolmentService enrolmentService=new EnrolmentService(new EnrolmentRepo("online_school_db"));
        enrolmentService.myCourses(x);
    }



}
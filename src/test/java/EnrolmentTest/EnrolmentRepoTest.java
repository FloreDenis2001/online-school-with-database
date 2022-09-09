package EnrolmentTest;

import model.Course;
import model.Enrolment;
import model.Student;
import org.junit.jupiter.api.Test;
import repository.CourseRepo;
import repository.EnrolmentRepo;
import repository.StudentRepo;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EnrolmentRepoTest {
    private EnrolmentRepo enrolmentRepo2;

    public EnrolmentRepoTest() {
        enrolmentRepo2 = new EnrolmentRepo("online_shop_test");
    }

    @Test
    public void clearAll() {
        EnrolmentRepo enrolmentRepo = enrolmentRepo2;
        enrolmentRepo.eraseAll();
    }

    @Test
    public void insertTest() {
        StudentRepo studentRepo = new StudentRepo("online_shop_test");
        Student x = new Student("Vasalie", "Adrian", 25, "denis2103", "adrian@yahoo.com");
        studentRepo.insert(x);
        CourseRepo courseRepo = new CourseRepo("online_shop_test");
        Course c = new Course("Web Programming", "Java");
        courseRepo.insert(c);
        EnrolmentRepo enrolmentRepo = enrolmentRepo2;
        Enrolment p = new Enrolment(1, 1, LocalDate.of(2022, 8, 22));
        enrolmentRepo.insert(p);
        assertEquals(1, enrolmentRepo.findByStudentId(1).getCourseId());
        enrolmentRepo.eraseAll();
        studentRepo.eraseAll();
        courseRepo.eraseAll();
    }

    @Test
    public void deleteTest() {
        StudentRepo studentRepo = new StudentRepo("online_shop_test");
        Student x = new Student("Vasalie", "Adrian", 25, "denis2103", "adrian@yahoo.com");
        studentRepo.insert(x);

        CourseRepo courseRepo = new CourseRepo("online_shop_test");
        Course c = new Course("Web Programming", "Java");
        courseRepo.insert(c);

        EnrolmentRepo enrolmentRepo = enrolmentRepo2;
        Enrolment p = new Enrolment(1, 1, LocalDate.of(2022, 8, 22));
        enrolmentRepo.insert(p);

        enrolmentRepo.delete("2022-8-22");
        assertEquals(null, enrolmentRepo.findByStudentId(1));

        enrolmentRepo.eraseAll();
        studentRepo.eraseAll();
        courseRepo.eraseAll();
    }

    @Test
    public void updateTest() {
        StudentRepo studentRepo = new StudentRepo("online_shop_test");
        Student x = new Student("Vasalie", "Adrian", 25, "denis2103", "adrian@yahoo.com");
        studentRepo.insert(x);

        CourseRepo courseRepo = new CourseRepo("online_shop_test");
        Course c = new Course("Web Programming", "Java");
        courseRepo.insert(c);

        EnrolmentRepo enrolmentRepo = enrolmentRepo2;
        Enrolment p = new Enrolment(1, 1, LocalDate.of(2022, 8, 22));
        enrolmentRepo.insert(p);

        enrolmentRepo.updateEnrol(1, 1);
        assertEquals(1, enrolmentRepo.findByStudentId(1).getCourseId());

        enrolmentRepo.eraseAll();
        studentRepo.eraseAll();
        courseRepo.eraseAll();

    }
}
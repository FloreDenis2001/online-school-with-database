package CourseTest;

import exceptii.StatusException;
import model.Course;
import org.junit.jupiter.api.Test;
import repository.CourseRepo;
import services.CourseService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private CourseRepo courseRepo;

    public CourseServiceTest() {

        courseRepo = new CourseRepo("online_shop_test");
    }

    @Test
    public void eraseTest() {
        courseRepo.eraseAll();
    }


    @Test
    public void addCourseTest() throws StatusException {
        CourseService courseService = new CourseService(courseRepo);
        Course x = new Course("sport", "fotbal");
        courseService.addCourse(x);
        assertEquals("fotbal", courseService.findByName("sport","fotbal").getDepartment());
        courseRepo.eraseAll();
    }
    @Test
    public void addCourseThrowTest() throws  StatusException{
        CourseService courseService = new CourseService(courseRepo);
        Course x = new Course("sport", "fotbal");
        courseService.addCourse(x);
        assertThrows(StatusException.class,()->courseService.addCourse(x));
        eraseTest();
    }

    @Test
    public void removeThrowTest() throws StatusException {
        CourseService courseService = new CourseService(courseRepo);
        assertThrows(StatusException.class, () -> courseService.removeCourse(new Course("sport", "fotbal")));
        eraseTest();
    }

    @Test
    public void removeCourseTest() throws StatusException {
        CourseService courseService = new CourseService(courseRepo);
        Course x = new Course("sport", "fotbal");
        courseService.addCourse(x);
        courseService.removeCourse(courseService.findByName("sport","fotbal"));
        assertEquals(null, courseService.findByName("sport","fotbal"));
        eraseTest();
    }

    @Test
    public void updateTest() throws StatusException {
        CourseService courseService = new CourseService(courseRepo);
        Course x = new Course("sport", "fotbal");
        courseService.addCourse(x);
        courseService.updateDepartmentName("fotbal","sport", "golf");
        assertEquals("golf", courseService.findByName("sport","golf").getDepartment());
        eraseTest();
    }

    @Test
    public void updateThrow() throws StatusException {
        CourseService courseService = new CourseService(courseRepo);
        assertThrows(StatusException.class, () -> courseService.updateDepartmentName("512", "denis","516"));
        eraseTest();
    }


}
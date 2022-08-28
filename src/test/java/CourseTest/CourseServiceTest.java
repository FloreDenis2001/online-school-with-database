package CourseTest;

import exceptii.StatusException;
import model.Course;
import org.junit.jupiter.api.Test;
import repository.CourseRepo;
import services.CourseService;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
    @Test
    public void findTest(){
        CourseService courseService=new CourseService();
        assertEquals("design",courseService.findById(9).getName());
    }


    @Test
    public void addCourseTest() throws StatusException {
        CourseService courseService=new CourseService();
        Course x=new Course("sport","fotbal");
        courseService.addCourse(x);
        assertEquals("fotbal",courseService.findById(26).getDepartment());

    }

    // nu pot sa sterg cursul
    @Test
    public void removeCourseTest() throws StatusException{
        CourseService courseService=new CourseService();
        courseService.removeCourse(courseService.findById(22));
        assertEquals(null,courseService.findById(22));
    }

    @Test
    public void updateTest() throws StatusException{
        CourseService courseService=new CourseService();
        courseService.updateDepartmentName(20,"Java Spring");
        assertEquals("Java Spring",courseService.findById(20).getDepartment());
    }

    @Test
    public void updateThrow() throws StatusException{
        CourseService courseService=new CourseService();
        assertThrows(StatusException.class,()->courseService.updateDepartmentName(512,"denis"));
    }



}
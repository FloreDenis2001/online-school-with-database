package CourseTest;

import model.Course;
import org.junit.jupiter.api.Test;
import repository.CourseRepo;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepoTest {
    private CourseRepo courseRepo2;

    public CourseRepoTest(){
        courseRepo2=new CourseRepo("online_shop_test");
    }

    @Test
    public void clearAll(){
        CourseRepo courseRepo=courseRepo2;
        courseRepo.eraseAll();
    }


    @Test
    public void insertTest() {
        CourseRepo courseRepo=courseRepo2;
        Course  c = new Course("Web Programming","Java");
        courseRepo.insert(c);
        assertEquals("Java",courseRepo.findByName(c.getName()).getDepartment());
        courseRepo.eraseAll();
    }

    @Test
    public void deleteTest(){
        CourseRepo courseRepo=courseRepo2;
        Course  c = new Course("sport","fotbal");
        courseRepo.insert(c);
        courseRepo.delete("sport");
        assertEquals(null,courseRepo.findByName(c.getName()));
        courseRepo.eraseAll();
    }

    @Test
    public void updateTest(){
        CourseRepo courseRepo=courseRepo2;
        Course  c = new Course("programming","java");
        courseRepo.insert(c);
        courseRepo.update("java","hardware");
        assertEquals("hardware",courseRepo.findByName(c.getName()).getDepartment());
    }

}
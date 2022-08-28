package CourseTest;

import model.Course;
import org.junit.jupiter.api.Test;
import repository.CourseRepo;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepoTest {
    @Test
    public void insertTest() {
        CourseRepo courseRepo=new CourseRepo();
        Course  c = new Course("Web Programming","Java");
        courseRepo.insert(c);
    }

    @Test
    public void deleteTest(){
        CourseRepo courseRepo=new CourseRepo();
        courseRepo.delete("sport");
    }

    @Test
    public void updateTest(){
        CourseRepo courseRepo=new CourseRepo();
        courseRepo.update("java","hardware");
    }

}
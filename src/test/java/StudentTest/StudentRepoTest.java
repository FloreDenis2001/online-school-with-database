package StudentTest;

import model.Student;
import org.junit.jupiter.api.Test;
import repository.EnrolmentRepo;
import repository.StudentRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentRepoTest {
    private StudentRepo studentRepo2;

    public StudentRepoTest() {
        studentRepo2 = new StudentRepo("online_shop_test");
    }

    @Test
    public void eraseAll() {
        StudentRepo studentRepo = studentRepo2;
        studentRepo.eraseAll();
    }

    @Test
    public void Allstudents(){
        StudentRepo studentRepo=new StudentRepo("online_school_db");
        List<Student> studentList= studentRepo.allStudent();
        for(Student x : studentList){
            System.out.println("Email : " +x.getEmail());
        }
    }

    @Test
    public void insertTest() {
        StudentRepo studentRepo = new StudentRepo("online_shop_test");
        Student x = new Student("Vasalie", "Adrian", 25, "denis2103", "adrian@yahoo.com");
        studentRepo.insert(x);
        assertEquals("denis2103", studentRepo.findByEmail("adrian@yahoo.com").getPassword());
        studentRepo.eraseAll();
    }

    @Test
    public void deleteTest() {
        StudentRepo studentRepo = new StudentRepo("online_shop_test");
        Student x = new Student("Vasalie", "Adrian", 25, "denis2103", "adrian@yahoo.com");
        studentRepo.insert(x);
        studentRepo.delete("adrian@yahoo.com");
        assertEquals(null, studentRepo.findByEmail("adrian@yahoo.com"));
        studentRepo.eraseAll();
    }

    @Test
    public void updateTest() {
        StudentRepo studentRepo = new StudentRepo("online_shop_test");
        Student x = new Student("Vasalie", "Adrian", 25, "denis2103", "adrian@yahoo.com");
        studentRepo.insert(x);
        studentRepo.update(x.getEmail(), "denisparolanoua2");
        assertEquals("denisparolanoua2", studentRepo.findByEmail(x.getEmail()).getPassword());
        studentRepo.eraseAll();
    }
}
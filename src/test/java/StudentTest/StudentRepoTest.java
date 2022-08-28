package StudentTest;

import model.Student;
import org.junit.jupiter.api.Test;
import repository.StudentRepo;


class StudentRepoTest {
    @Test
    public void insertTest() {
        StudentRepo studentRepo = new StudentRepo();
        Student x = new Student("Flore", "Daniel", 25, "denis2103", "daniel@yahoo.com");
        studentRepo.insert(x);
    }

    @Test
    public void deleteTest(){
        StudentRepo studentRepo=new StudentRepo();
        studentRepo.delete("Siusan@gmail.com");
    }

    @Test
    public void updateTest(){
        StudentRepo studentRepo=new StudentRepo();
        studentRepo.update(28,"denis2001");
    }
}
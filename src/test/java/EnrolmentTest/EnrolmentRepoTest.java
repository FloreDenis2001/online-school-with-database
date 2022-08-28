package EnrolmentTest;

import model.Enrolment;
import org.junit.jupiter.api.Test;
import repository.EnrolmentRepo;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EnrolmentRepoTest {
    @Test
    public void insertTest(){
        EnrolmentRepo enrolmentRepo=new EnrolmentRepo();
        Enrolment x = new Enrolment(4,12, LocalDate.of(2022,8,22));
        enrolmentRepo.insert(x);
    }
    @Test
    public void deleteTest(){
        EnrolmentRepo enrolmentRepo=new EnrolmentRepo();
        enrolmentRepo.delete("2021-12-23");
    }
    @Test
    public void updateTest(){
        EnrolmentRepo enrolmentRepo=new EnrolmentRepo();
        enrolmentRepo.updateEnrol(16,15);
    }
}
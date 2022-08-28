package EnrolmentTest;

import exceptii.StatusException;
import model.Enrolment;
import org.junit.jupiter.api.Test;
import services.EnrolmentService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EnrolmentServiceTest {

    @Test
    public void findById(){
        EnrolmentService enrolmentService=new EnrolmentService();
        assertEquals(20,enrolmentService.findById(8).getStudentId());
    }

    @Test
    public void addEnrolTest() throws StatusException {
        EnrolmentService enrolmentService=new EnrolmentService();
        Enrolment t = new Enrolment(13,2, LocalDate.of(2022,8,28));
        enrolmentService.addEnrolment(t);
        assertEquals(2,enrolmentService.findById(33).getCourseId());
    }

    @Test
    public void removeEnrolTest() throws  StatusException{
        EnrolmentService enrolmentService=new EnrolmentService();
        enrolmentService.removeEnrolment(14);
        assertEquals(null,enrolmentService.findById(14));
    }

    @Test
    public void updateEnrolemntTest() throws StatusException{
        EnrolmentService enrolmentService=new EnrolmentService();
        enrolmentService.updateEnrolemnt(18,3);
        assertEquals(3,enrolmentService.findById(18).getCourseId());
    }



}
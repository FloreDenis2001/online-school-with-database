package services;

import exceptii.StatusException;
import model.Enrolment;
import repository.EnrolmentRepo;

import java.util.ArrayList;
import java.util.List;

public class EnrolmentService {
    EnrolmentRepo enrolmentRepo;

    public EnrolmentService() {
        enrolmentRepo = new EnrolmentRepo();
    }

    public Enrolment findById(int id) {
        List<Enrolment> enrolmentList = enrolmentRepo.allEnrolment();
        for (Enrolment x : enrolmentList) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public void addEnrolment(Enrolment e) throws StatusException {
        Enrolment t = findById(e.getId());
        if (t == null) {
            enrolmentRepo.insert(e);
        } else {
            throw new StatusException("Enrolemnt existent!");
        }
    }

    public void removeEnrolment(int id) throws StatusException {
        Enrolment t = findById(id);
        if (t != null) {
            enrolmentRepo.delete(t.getCreateAt().toString());
        } else {
            throw new StatusException("Enrolmentul  nu exista ! ");
        }
    }

    public void updateEnrolemnt(int id, int courseIdNou) throws StatusException {
        Enrolment x = findById(id);
        if (x != null) {
            enrolmentRepo.updateEnrol(id, courseIdNou);
        } else {
            throw new StatusException("Enrolmentul nu exista");
        }
    }

    public List<Enrolment> listOfStudentById(int id) {
        List<Enrolment> enrolments = enrolmentRepo.allEnrolment();
        List<Enrolment> studentEnrol=new ArrayList<>();
        for (Enrolment t : enrolments) {
            if (t.getStudentId() == id) {
                studentEnrol.add(t);
            }
        }
        return studentEnrol;
    }

    public void removeEnrolemntByStudentId(int studentId) throws StatusException {
        List<Enrolment> listOfStudent=listOfStudentById(studentId);
        for(Enrolment x : listOfStudent){
            enrolmentRepo.deleteByStudentId(x.getStudentId());
        }
    }


}

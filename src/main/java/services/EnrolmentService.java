package services;

import exceptii.StatusException;
import model.Course;
import model.Enrolment;
import model.Student;
import repository.CourseRepo;
import repository.EnrolmentRepo;

import java.util.ArrayList;
import java.util.List;

public class EnrolmentService {
    EnrolmentRepo enrolmentRepo;

    public EnrolmentService(EnrolmentRepo enrolmentRepo1) {
        enrolmentRepo = enrolmentRepo1;
    }

    public Enrolment findByStudentId(int studentId, int courseId) {
        List<Enrolment> enrolmentList = enrolmentRepo.allEnrolment();
        for (Enrolment x : enrolmentList)
            if (x.getStudentId() == studentId) {
                if (x.getCourseId() == courseId)
                    return x;
            }
        return null;
    }

    public void addEnrolment(Enrolment e) throws StatusException {
        Enrolment t = findByStudentId(e.getStudentId(), e.getCourseId());
        if (t == null) {
            enrolmentRepo.insert(e);
        } else {
            throw new StatusException("Enrolemnt existent!");
        }
    }

    public void removeEnrolment(int studentId, int courseId) throws StatusException {
        Enrolment t = findByStudentId(studentId, courseId);
        if (t != null) {
            enrolmentRepo.delete(t.getCreateAt().toString());
        } else {
            throw new StatusException("Enrolmentul  nu exista ! ");
        }
    }

    public void updateEnrolemnt(int studentId, int courseIdVechi, int courseIdNou) throws StatusException {
        Enrolment x = findByStudentId(studentId, courseIdVechi);
        if (x != null) {
            enrolmentRepo.updateEnrol(studentId, courseIdNou);
        } else {
            throw new StatusException("Enrolmentul nu exista");
        }
    }

    public ArrayList<Integer> courseIds(Student student) {
        List<Enrolment> enrolmentList = enrolmentRepo.allEnrolment();
        ArrayList<Integer> courses = new ArrayList<>();
        for (Enrolment x : enrolmentList) {
            if (x.getStudentId() == student.getId()) {
                courses.add(x.getCourseId());
            }
        }
        return courses;
    }

    public void myCourses(Student student) {
        ArrayList<Integer> c = courseIds(student);
        int val = 0;
        CourseRepo courseRepo = new CourseRepo("online_school_db");
        List<Course> courses = courseRepo.allCourse();
        for (int i = 0; i <= c.size() - 1; i++) {
            val = c.get(i);
            for (Course x : courses) {
                if (x.getId() == val) {
                    System.out.println("Name : " + x.getName() + "\nDepartment : " + x.getDepartment()+"\n");
                }
            }
        }
    }

}

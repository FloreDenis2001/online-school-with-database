package services;

import exceptii.StatusException;
import model.Course;
import model.Student;
import repository.StudentRepo;

import java.util.List;

public class StudentService {
    StudentRepo studentRepo;
    EnrolmentService enrolmentService;

    public StudentService() {
        studentRepo = new StudentRepo();
        enrolmentService=new EnrolmentService();
    }

    public Student findById(int id) {
        List<Student> studentList = studentRepo.allStudent();
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }


    public void addStudent(Student student) throws StatusException {
        Student t = findById(student.getId());
        if (t == null) {
            studentRepo.insert(student);
        } else {
            throw new StatusException("Studentul Exista Deja ! ");
        }
    }

    public void removeStudent(Student t) throws StatusException {
        Student x = findById(t.getId());
        if (x != null) {
            enrolmentService.removeEnrolemntByStudentId(t.getId());
            studentRepo.delete(t.getEmail());
        } else {
            throw new StatusException("Studentul nu exista ! ");
        }
    }

    public void updatePassword(int id, String new_password) throws StatusException {
        Student t = findById(id);
        if (t != null) {
            studentRepo.update(id, new_password);
        } else {
            throw new StatusException("Studentul nu exista");
        }
    }
}

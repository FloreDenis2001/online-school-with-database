package services;

import exceptii.StatusException;
import model.Book;
import model.Course;
import model.Student;
import repository.BookRepo;
import repository.StudentRepo;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    StudentRepo studentRepo;
    EnrolmentService enrolmentService;

    public StudentService(StudentRepo studentRepo2) {
        studentRepo = studentRepo2;
    }

    public Student findByEmail(String email) {
        List<Student> studentList = studentRepo.allStudent();
        for (Student s : studentList) {
            if (s.getEmail().compareTo(email) == 0) {
                return s;
            }
        }
        return null;
    }


    public void addStudent(Student student) throws StatusException {
        Student t = findByEmail(student.getEmail());
        if (t == null) {
            studentRepo.insert(student);
        } else {
            throw new StatusException("Studentul Exista Deja ! ");
        }
    }

    public void remove(String email) throws StatusException {
        Student p = findByEmail(email);
        if (p != null) {
            studentRepo.delete(p.getEmail());
        } else {
            throw new StatusException("Studentul nu exista ! ");
        }
    }

    public void updatePassword(String email, String new_password) throws StatusException {
        Student t = findByEmail(email);
        if (t != null) {
            studentRepo.update(email, new_password);
        } else {
            throw new StatusException("Studentul nu exista");
        }
    }

    public void myBooks(Student student) {
        BookRepo bookRepo = new BookRepo("online_school_db");
        List<Book> books = bookRepo.allBook();
        for (Book x : books) {
            if (x.getStudent_id() == student.getId()) {
                System.out.println("Book Name : " + x.getBook_name() + "\nCreate At : " + x.getCreate_at() + "\n");
            }
        }
    }

    public Student verifyAcc(String password, String email) {
        List<Student> studentList = studentRepo.allStudent();
        for (Student x : studentList) {
            if (x.getEmail().compareTo(email)==0 && x.getPassword().compareTo(password)==0) {
                return x;
            }
        }
        return null;
    }

}



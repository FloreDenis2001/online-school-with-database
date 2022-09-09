package services;

import exceptii.StatusException;
import model.Book;
import model.Course;
import repository.BookRepo;
import repository.CourseRepo;

import java.util.List;

public class CourseService {
    CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo2) {
        courseRepo = courseRepo2;
    }


    public Course findByName(String name, String department) {
        List<Course> e = courseRepo.allCourse();
        for (Course t : e)
            if (t.getDepartment().compareTo(department) == 0 && t.getName().compareTo(name) == 0) {
                return t;
            }

        return null;
    }

    public void addCourse(Course course) throws StatusException {
        Course t = findByName(course.getName(), course.getDepartment());
        if (t == null) {
            courseRepo.insert(course);
        } else {
            throw new StatusException("Cursul Exista Deja ! ");
        }
    }

    public void removeCourse(Course t) throws StatusException {
        Course x = findByName(t.getName(),t.getDepartment());
        if (x != null) {
            courseRepo.delete(t.getName());
        } else {
            throw new StatusException("Cursul nu exista ! ");
        }
    }

    public void updateDepartmentName(String department,String name, String new_department_name) throws StatusException {
        Course t = findByName(name,department);
        if (t != null) {
            courseRepo.update(t.getDepartment(), new_department_name);
        } else {
            throw new StatusException("Cursul nu exista");
        }
    }

    public void allCourse() {
        List<Course> courses = courseRepo.allCourse();
        for (Course x : courses)
            System.out.println(x);

    }
}

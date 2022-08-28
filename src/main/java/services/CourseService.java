package services;

import exceptii.StatusException;
import model.Book;
import model.Course;
import repository.BookRepo;
import repository.CourseRepo;

import java.util.List;

public class CourseService {
    CourseRepo courseRepo;

    public CourseService() {
        courseRepo = new CourseRepo();
    }

    public Course findById(int id) {
        List<Course> e = courseRepo.allCourse();
        for (Course t : e) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void addCourse(Course course) throws StatusException {
        Course t = findById(course.getId());
        if (t == null) {
            courseRepo.insert(course);
        } else {
            throw new StatusException("Cursul Exista Deja ! ");
        }
    }

    public void removeCourse(Course t) throws StatusException {
        Course x = findById(t.getId());
        if (x != null) {
            courseRepo.delete(t.getName());
        } else {
            throw new StatusException("Cursul nu exista ! ");
        }
    }

    public void updateDepartmentName(int id, String new_name) throws StatusException {
        Course t = findById(id);
        if (t != null) {
            courseRepo.update(t.getDepartment(), new_name);
        } else {
            throw new StatusException("Cursul nu exista");
        }
    }
}

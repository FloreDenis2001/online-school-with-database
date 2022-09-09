package repository;

import model.Book;
import model.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseRepo extends Repository{


    public CourseRepo(String database) {
        super(database);
    }
    public void eraseAll(){
        String check="SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll="truncate course";
        executeStatement(eraseAll);
    }
    @Override
    public void insert(Object x) {
        Course t = (Course) x;
        String insert = "insert into course (name,department) values("+String.format("'%s','%s'",t.getName(),t.getDepartment())+")";
        executeStatement(insert);
    }

    @Override
    public void delete(String courseName) {
        String delete=String.format("delete from course where name='%s' ",courseName);
        executeStatement(delete);
    }



    public void update(String old_department, String update_department) {
         String updateCourse=String.format("update course set department='%s' where department='%s'",update_department,old_department);
         executeStatement(updateCourse);
    }

    public Course findByName(String name){
        List<Course> courses=allCourse();
        for(Course x:courses){
            if(x.getName().compareTo(name)==0){
                return x;
            }
        }
        return null;
    }

    public List<Course> allCourse() {
        executeStatement("select * from course");
        List<Course> course = new ArrayList<>();


        try {
            ResultSet set= statement.getResultSet();

            while (set.next()){
                course.add(new Course(set.getInt(1),set.getString(2),set.getString(3)));
            }

            return course;


        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }
}

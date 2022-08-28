package repository;

import model.Book;
import model.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo extends Repository {


    @Override
    public void insert(Object x) {
        Student s=(Student) x;
        String insert = "insert into student (firstName,lastName,age,password,email) values("+String.format("'%s','%s',%d,'%s','%s' ",s.getFirstName(),s.getLastName(),s.getAge(),s.getPassword(),s.getEmail())+")";
        executeStatement(insert);
    }

    @Override
    public void delete(String emailFind) {
          String delete = String.format("delete from student where email='%s'",emailFind);
          executeStatement(delete);
    }

    public void update(int id, String updatePassword) {
          String update=String.format("update student set password='%s' where id=%d",updatePassword,id);
          executeStatement(update);
    }
    public List<Student> allStudent() {
        executeStatement("select * from student");
        List<Student> students = new ArrayList<>();


        try {
            ResultSet set= statement.getResultSet();

            while (set.next()){
                students.add(new Student(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getString(5), set.getString(6)));
            }

            return students;


        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

}

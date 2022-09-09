package repository;

import model.Book;
import model.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo extends Repository {


    public StudentRepo(String database) {
        super(database);
    }

    public void eraseAll() {
        String check = "SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll = "truncate student";
        executeStatement(eraseAll);
    }

    public Student findByEmail(String email) {
        List<Student> students = allStudent();
        for (Student x : students) {
            if (x.getEmail().compareTo(email) == 0) {
                return x;
            }
        }
        return null;
    }


    @Override
    public void insert(Object x) {
        Student s = (Student) x;
        String insert = "insert into student (firstName,lastName,age,password,email) values(" + String.format("'%s','%s',%d,'%s','%s' ", s.getFirstName(), s.getLastName(), s.getAge(), s.getPassword(), s.getEmail()) + ")";
        executeStatement(insert);
    }

    @Override
    public void delete(String emailFind) {
        String delete = String.format("delete from student where email='%s'", emailFind);
        executeStatement(delete);
    }

    public void update(String email, String updatePassword) {
        String update = String.format("update student set password='%s' where email='%s'", updatePassword, email);
        executeStatement(update);
    }

    public List<Student> allStudent() {
        executeStatement("select * from student");
        List<Student> students = new ArrayList<>();


        try {
            ResultSet set = statement.getResultSet();

            while (set.next()) {
                students.add(new Student(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4), set.getString(5), set.getString(6)));
            }

            return students;


        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }


}

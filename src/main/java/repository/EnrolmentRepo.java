package repository;

import model.Enrolment;
import model.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnrolmentRepo extends Repository {
    public EnrolmentRepo(String database) {
        super(database);
    }

    public void eraseAll() {
        String check = "SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll = "truncate enrolment";
        executeStatement(eraseAll);
    }

    public Enrolment findByStudentId(int studentId) {
        List<Enrolment> enrolments = allEnrolment();
        for (Enrolment x : enrolments) {
            if (x.getStudentId() == studentId) {
                return x;
            }
        }
        return null;
    }

    @Override
    public void insert(Object x) {
        Enrolment t = (Enrolment) x;
        String insert = "insert into enrolment (studentId,courseId,createAt) values(" + String.format("%d,%d,'%s'", t.getStudentId(), t.getCourseId(), t.getCreateAt()) + ")";
        executeStatement(insert);
    }

    @Override
    public void delete(String deleteByCreateAt) {
        String delete = String.format("delete from enrolment where createAt='%s'", deleteByCreateAt);
        executeStatement(delete);
    }

    public void updateEnrol(int id, int courseIdNou) {
        String update = String.format("update enrolment set courseId=%d where id=%d", courseIdNou, id);
        executeStatement(update);
    }




    public List<Enrolment> allEnrolment() {
        executeStatement("select * from enrolment");
        List<Enrolment> enrolments = new ArrayList<>();


        try {
            ResultSet set = statement.getResultSet();

            while (set.next()) {
                enrolments.add(new Enrolment(set.getInt(1), set.getInt(2), set.getInt(3), set.getDate(4).toLocalDate()));

            }

            return enrolments;


        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }


}

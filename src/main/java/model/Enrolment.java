package model;

import java.time.LocalDate;

public class Enrolment implements Comparable<Enrolment> {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate createAt;

    public Enrolment(int id, int studentId, int courseId, LocalDate createAt) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.createAt = createAt;
    }

    public Enrolment(int studentId, int courseId, LocalDate createAt) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }


    @Override
    public String toString() {
        String text = "Id : " + this.id + "\n";
        text += "Student Id : " + this.studentId + "\n";
        text += "Courese Id : " + this.courseId + "\n";
        text += "Create At : " + this.createAt + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Enrolment x = (Enrolment) o;
        return x.getStudentId() == this.studentId;
    }


    @Override
    public int compareTo(Enrolment o) {
        if (this.courseId > o.getCourseId()) {
            return 1;
        } else if (this.courseId < o.getCourseId()) {
            return -1;
        } else {
            return 0;
        }
    }
}

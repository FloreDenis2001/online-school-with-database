package model;

public class Course implements Comparable<Course> {
    private int id;
    private String name;
    private String department;

    public Course(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Course(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        String text = "Id : " + this.id + "\n";
        text += "Name : " + this.name + "\n";
        text += "Department : " + this.department + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Course t = (Course) o;
        return t.getId() == this.getId();
    }


    @Override
    public int compareTo(Course o) {
        if (o.getId() > this.id) {
            return -1;
        } else if (o.getId() < this.id) {
            return 1;
        } else {
            return 0;
        }
    }


}

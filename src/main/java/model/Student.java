package model;

public class Student implements Comparable<Student> {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String password;
    private String email;

    public Student(int id, String firstName, String lastName, int age, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.email = email;
    }

    public Student(String firstName, String lastName, int age, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String text = "Id : " + this.id + "\n";
        text += "First Name : " + this.firstName + "\n";
        text += "Last Name : " + this.lastName + "\n";
        text += "Age : " + this.age + "\n";
        text += "Password : " + this.password + "\n";
        text += "Email : " + this.email + "\n";

        return text;
    }

    @Override
    public boolean equals(Object o) {
        Student x = (Student) o;
        return this.age == x.getAge();
    }


    @Override
    public int compareTo(Student o) {

        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }

}

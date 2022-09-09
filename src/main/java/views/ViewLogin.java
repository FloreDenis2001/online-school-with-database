package views;

import exceptii.StatusException;
import model.Student;
import repository.StudentRepo;
import services.StudentService;

import java.util.Scanner;

public class ViewLogin {
    private StudentService studentService;
    private Scanner scanner;
    private String database = "online_school_db";

    public ViewLogin() {
        this.studentService = new StudentService(new StudentRepo(database));
        this.scanner = new Scanner(System.in);
    }

    public void meniu() {
        System.out.println("-------------------LOGIN-----------------");
        System.out.println("Apasa 1 pentru a te loga");
        System.out.println("Apasa 2 pentru a te inregistra");
        System.out.println("Apasa 3 pentru a iesi");
        System.out.println("-----------------------------------------");
    }


    public void play() throws StatusException {
        int choose;
        boolean run = true;
        while (run) {
            meniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    login();
                    break;
                case 2:
                    registration();
                    break;
                case 3:
                    logout();
                    run = false;
                    break;
                default:
                    meniu();
            }
        }

    }


    public void login() throws StatusException {
        System.out.println("Introduceti emailul utilizatorului : ");
        String email = scanner.nextLine();
        System.out.println("Introduceti parola : ");
        String password = scanner.nextLine();
        Student x = studentService.verifyAcc(password,email);
        if (x != null) {
            ViewStudent viewStudent = new ViewStudent(x);
            viewStudent.play();
        } else {
            System.out.println("Datele au fost introduse gresit ! ");
        }

    }

    public void registration() throws StatusException {
        System.out.println("FirstName : ");
        String firstname = scanner.nextLine();
        System.out.println("LastName : ");
        String lastname = scanner.nextLine();
        System.out.println("Age : ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Email : ");
        String email = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();
        Student x = new Student(firstname, lastname, age, password, email);
        studentService.addStudent(x);
    }

    public void logout() {
        System.out.println("LOGIN OUT");
    }
}

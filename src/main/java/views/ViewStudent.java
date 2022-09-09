package views;

import exceptii.StatusException;
import model.Book;
import model.Course;
import model.Enrolment;
import model.Student;
import repository.BookRepo;
import repository.CourseRepo;
import repository.EnrolmentRepo;
import repository.StudentRepo;
import services.BookService;
import services.CourseService;
import services.EnrolmentService;
import services.StudentService;

import java.time.LocalDate;
import java.util.Scanner;

public class ViewStudent {
    private BookService bookService;
    private CourseService courseService;
    private EnrolmentService enrolmentService;
    private Scanner scanner;
    private Student logat;
    private StudentService studentService;
    private String database = "online_school_db";

    public ViewStudent(Student student) {
        this.bookService = new BookService(new BookRepo(database));
        this.courseService = new CourseService(new CourseRepo(database));
        this.enrolmentService = new EnrolmentService(new EnrolmentRepo(database));
        this.studentService = new StudentService(new StudentRepo(database));
        this.scanner = new Scanner(System.in);
        this.logat = student;
    }


    public void meniu() {
        System.out.println("--------Bine ai venit " + this.logat.getFirstName() + " -----------------");
        System.out.println("Apasa 1 pentru a afisa lista cursurilor");
        System.out.println("Apasa 2 pentru a afisa lista cartilor");
        System.out.println("Apasa 3 pentru a vedea cursurile la care sunteti inscris ");
        System.out.println("Apasa 4 pentru a vedea cartile achizitionate");
        System.out.println("Apasa 5 pentru a te inscrie la un curs");
        System.out.println("Apasa 6 pentru a  achizitiona o carte");
        System.out.println("Apasa 7 pentru a te dezabona de la un curs");
        System.out.println("Apasa 8 pentru a te deconecta");
        System.out.println("------------------------------------");
    }

    public void play() throws StatusException {
        int choose;
        boolean running = true;
        while (running) {
            meniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    courseService.allCourse();
                    break;
                case 2:
                    bookService.booksAvailable();
                    break;
                case 3:
                    enrolmentService.myCourses(logat);
                    break;
                case 4:
                    studentService.myBooks(logat);
                    break;
                case 5:
                    joinCourse();
                    break;

                case 6:
                    buyBook();
                    break;
                case 7:
                    dropCourse();
                    break;
                case 8:
                    running = false;
                    break;
            }
        }
    }

    public void joinCourse() throws StatusException {
        CourseService courseService2 = this.courseService;
        EnrolmentService enrolmentService2 = this.enrolmentService;
        System.out.println("Name of course : ");
        String name = scanner.nextLine();
        System.out.println("Deparment of course : ");
        String department = scanner.nextLine();
        Course x = courseService2.findByName(name, department);
        this.enrolmentService.addEnrolment(new Enrolment(logat.getId(), x.getId(), LocalDate.now()));
    }

    public void buyBook() throws StatusException {
        BookService bookService2 = this.bookService;
        System.out.println("Name of book : ");
        String name = scanner.nextLine();
        bookService2.addBook(new Book(logat.getId(), name, LocalDate.now()));
    }

    public void dropCourse() throws StatusException {
        EnrolmentService enrolmentService2 = this.enrolmentService;
        System.out.println("Name of course :");
        String name = scanner.nextLine();
        System.out.println("Department of course : ");
        String department = scanner.nextLine();
        Course x = courseService.findByName(name, department);
        enrolmentService2.removeEnrolment(logat.getId(), x.getId());
    }

}

package views;

import model.Student;
import services.BookService;
import services.CourseService;
import services.EnrolmentService;
import services.StudentService;

import java.util.Scanner;

public class ViewStudent {
    private BookService bookService;
    private CourseService courseService;
    private EnrolmentService enrolmentService;
    private Scanner scanner;
    private Student logat;
    private StudentService studentService;

    public ViewStudent(Student student){
        this.bookService=new BookService();
        this.courseService=new CourseService();
        this.enrolmentService=new EnrolmentService();
        this.studentService=new StudentService();
        this.scanner=new Scanner(System.in);
        this.logat=student;
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

    public void play(){int choose;
        boolean running = true;
        while (running) {
            meniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 0:
                    running=false;
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;

            }
        }}


}

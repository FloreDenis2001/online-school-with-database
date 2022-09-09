import exceptii.StatusException;
import model.Student;
import repository.BookRepo;
import repository.StudentRepo;
import services.BookService;
import services.StudentService;
import views.ViewLogin;
import views.ViewStudent;

public class Application {
    public static void main(String[] args) throws StatusException {
        ViewLogin viewLogin=new ViewLogin();
        viewLogin.play();
    }
}

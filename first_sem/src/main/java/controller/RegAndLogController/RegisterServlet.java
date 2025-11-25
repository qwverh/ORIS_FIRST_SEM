package controller.RegAndLogController;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import model.Teacher;
import service.StudentService;
import service.TeacherService;
import util.PasswordUtil;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final StudentService studentService = new StudentService();
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/register.ftlh").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String fullName = req.getParameter("full_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        try {
            if ("student".equals(role)) {
                String groupNumber = req.getParameter("group_number");
                int courseNumber = Integer.parseInt(req.getParameter("course_number"));

                Student s = new Student();
                s.setFullName(fullName);
                s.setEmail(email);
                s.setPasswordHash(PasswordUtil.hashPassword(password));
                s.setGroupNumber(groupNumber);
                s.setCourseNumber(courseNumber);
                s.setTeacherId(null);
                studentService.register(s);

            } else if ("teacher".equals(role)) {
                Teacher t = new Teacher();
                t.setFullName(fullName);
                t.setEmail(email);
                t.setPasswordHash(PasswordUtil.hashPassword(password));
                teacherService.register(t);
            }

            resp.sendRedirect("login");

        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Неверный формат номера курса");
            req.getRequestDispatcher("/register.ftlh").forward(req, resp);
        }
    }
}

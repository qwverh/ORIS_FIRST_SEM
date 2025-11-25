package controller.TeacherController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;
import service.StudentService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/teacher/mystudents")
public class TeacherStudentsController extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int teacherId = (int) session.getAttribute("teacherId");

        try {
            List<Student> students = studentService.findByTeacherId(teacherId);
            req.setAttribute("students", students);
            req.getRequestDispatcher("/teacher_students.ftlh").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

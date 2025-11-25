package controller.RegAndLogController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;
import model.Teacher;
import service.StudentService;
import service.TeacherService;
import util.PasswordUtil;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/login.ftlh").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        try {
            HttpSession session = req.getSession(true);
            if ("student".equals(role)) {
                Student s = studentService.findByEmail(email);
                if (s == null || !PasswordUtil.checkPassword(password, s.getPasswordHash())) {
                    resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Неверный логин или пароль");
                    return;
                }
                session.setAttribute("role", "student");
                session.setAttribute("studentId", s.getId());
                resp.sendRedirect("student/profile");

            } else if ("teacher".equals(role)) {
                Teacher t = teacherService.findByEmail(email);
                if (t == null || !PasswordUtil.checkPassword(password, t.getPasswordHash())) {
                    resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Неверный логин или пароль");
                    return;
                }
                session.setAttribute("role", "teacher");
                session.setAttribute("teacherId", t.getId());
                resp.sendRedirect("teacher/profile");
            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
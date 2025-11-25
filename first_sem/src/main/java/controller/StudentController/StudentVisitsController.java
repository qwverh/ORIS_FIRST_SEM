package controller.StudentController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.StudentVisit;
import service.StudentVisitService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/student/visits")
public class StudentVisitsController extends HttpServlet {
    private final StudentVisitService studentVisitService = new StudentVisitService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int studentId = (int) session.getAttribute("studentId");

        try {
            List<StudentVisit> visits = studentVisitService.getVisitsByStudent(studentId);
            req.setAttribute("visits", visits);
            req.getRequestDispatcher("/student_visits.ftlh").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}



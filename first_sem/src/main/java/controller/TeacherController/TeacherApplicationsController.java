package controller.TeacherController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.StudentVisitService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@WebServlet("/teacher/applications")
public class TeacherApplicationsController extends HttpServlet {

    private final StudentVisitService studentVisitService = new StudentVisitService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int teacherId = (int) session.getAttribute("teacherId");

        try {
            List<Map<String, Object>> pendingApplications = studentVisitService.getPendingByTeacher(teacherId);
            req.setAttribute("applications", pendingApplications);
            req.getRequestDispatcher("/teacher_applications.ftlh").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int studentId = Integer.parseInt(req.getParameter("student_id"));
        int visitId = Integer.parseInt(req.getParameter("visit_id"));

        try {
            if ("approve".equals(action)) {
                studentVisitService.updateStatus(studentId, visitId, "Одобрено");
            } else if ("reject".equals(action)) {
                studentVisitService.updateStatus(studentId, visitId, "Отклонено");
            }

            resp.sendRedirect("applications");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

}

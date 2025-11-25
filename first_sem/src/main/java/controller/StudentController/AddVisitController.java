package controller.StudentController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.StudentVisit;
import model.Visit;
import service.StudentVisitService;
import service.VisitService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/student/addvisit")
public class AddVisitController extends HttpServlet {
    private final StudentVisitService studentVisitService = new StudentVisitService();
    private final VisitService visitService = new VisitService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add_visit.ftlh").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int studentId = (int) session.getAttribute("studentId");

        try {
            LocalDate date = LocalDate.parse(req.getParameter("visit_date"));
            LocalTime time = LocalTime.parse(req.getParameter("visit_time"));

            Visit visit = new Visit();
            visit.setVisitDate(date);
            visit.setVisitTime(time);
            int visitId = visitService.create(visit);


            StudentVisit studentVisit = new StudentVisit();
            studentVisit.setStudentId(studentId);
            studentVisit.setVisitId(visitId);
            studentVisit.setStatus("На рассмотрении");

            studentVisitService.create(studentVisit);

            resp.sendRedirect("../student/visits");

        } catch (SQLException e) {
            throw new ServletException("Ошибка при создании посещения", e);
        } catch (Exception e) {
            throw new ServletException("Неверный формат данных", e);
        }
    }
}


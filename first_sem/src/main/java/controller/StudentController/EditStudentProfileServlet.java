package controller.StudentController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;
import model.Teacher;
import service.StudentService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/student/editprofile")
public class EditStudentProfileServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int studentId = (int) session.getAttribute("studentId");

        try {
            Student student = studentService.findById(studentId);
            List<Teacher> teachers = studentService.getAllTeachers();

            req.setAttribute("student", student);
            req.setAttribute("teachers", teachers);
            req.getRequestDispatcher("/edit_student_profile.ftlh").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int studentId = (int) session.getAttribute("studentId");
        String action = req.getParameter("action");

        try {
            if ("update".equals(action)) {
                Student student = studentService.findById(studentId);
                student.setFullName(req.getParameter("full_name"));
                student.setEmail(req.getParameter("email"));
                student.setGroupNumber(req.getParameter("group_number"));
                student.setCourseNumber(Integer.parseInt(req.getParameter("course_number")));

                String teacherIdStr = req.getParameter("teacher_id");
                if (teacherIdStr != null && !teacherIdStr.isEmpty()) {
                    student.setTeacherId(Integer.parseInt(teacherIdStr));
                } else {
                    student.setTeacherId(null);
                }

                studentService.updateStudent(student);
                resp.sendRedirect("profile");
            } else if ("delete".equals(action)) {
                studentService.deleteStudent(studentId);
                resp.sendRedirect("../logout");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Неверный формат данных");
            doGet(req, resp);
        }
    }
}

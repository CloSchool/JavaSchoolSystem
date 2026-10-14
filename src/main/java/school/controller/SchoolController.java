package school.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import school.business.Subject;
import school.data.SubjectDB;

import java.io.IOException;
import java.util.List;

@WebServlet("/displaySubjects")
public class SchoolController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Subject> subjects = SubjectDB.getAllSubjects();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/subjects.jsp").forward(request, response);
    }
}
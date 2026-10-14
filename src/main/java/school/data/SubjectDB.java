package school.data;

import school.business.Subject;
import school.business.Teacher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDB {
    public static List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        String query = "SELECT s.subject_code, s.subject_name, t.teacher_id, t.name, t.email " +
                "FROM subject s LEFT JOIN teacher t ON s.teacher_id = t.teacher_id";

        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectCode(rs.getString("subject_code"));
                subject.setSubjectName(rs.getString("subject_name"));

                Teacher teacher = new Teacher();
                teacher.setTeacherId(rs.getInt("teacher_id"));
                teacher.setName(rs.getString("name"));
                teacher.setEmail(rs.getString("email"));

                subject.setTeacher(teacher);
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }
}
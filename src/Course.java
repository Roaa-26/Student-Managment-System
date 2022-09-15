import java.util.LinkedList;

public class Course {

    String id;
    String courseName;
    Database db;
    LinkedList<String> assignments;
    LinkedList<String> students;
    LinkedList<CourseAttendance> courseAttendance;

    public Course(String id, String courseName) {
        this.id = id;
        this.courseName = courseName;
        this.db = this.db.getInstance();
        this.assignments = new LinkedList<String>();
        this.students = new LinkedList<String>();
        this.courseAttendance = new LinkedList<CourseAttendance>();
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public void addCourseAttendance(CourseAttendance courseAttendance) {
        this.courseAttendance.add(courseAttendance);
    }

    public void addAssignment(String assignment){
        assignments.add(assignment);
    }
    public void addStudent(String student){

        students.add(student);
    }
    public void showAssignments(){
        for(String ass:assignments){
            System.out.println(db.Assignmnets.get(ass).toString());
        }
    }
}

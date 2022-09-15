import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Teacher {

     String id;
     String name;
     String email;
     String mobileNumber;
     Database db;


     public Teacher(String id, String name, String email, String mobileNumber) {
          this.id = id;
          this.name = name;
          this.email = email;
          this.mobileNumber = mobileNumber;
          this.db=this.db.getInstance();
     }

     @Override
     public String toString() {
          return "Teacher{" +
                  "id='" + id + '\'' +
                  ", name='" + name + '\'' +
                  ", email='" + email + '\'' +
                  ", mobileNumber='" + mobileNumber + '\'' +
                  '}';
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Teacher teacher = (Teacher) o;
          return Objects.equals(id, teacher.id) && Objects.equals(name, teacher.name) && Objects.equals(email, teacher.email) && Objects.equals(mobileNumber, teacher.mobileNumber);
     }

     @Override
     public int hashCode() {
          return Objects.hash(id, name, email, mobileNumber);
     }

     public void viewStudentsAssignedCourses(){

          for (HashMap.Entry<String, Student> entry :db.Students.entrySet()) {

               System.out.println("Student with the following info: "+entry.getValue().toString());
               System.out.println("is assigned to following courses");
               for(String courseId:entry.getValue().enrolledCourses){

                    System.out.println(db.Courses.get(courseId).toString());
               }


          }

     }

     public void getStudentsInCourse(String CourseID){
          System.out.println("Students in course: "+db.Courses.get(CourseID).courseName);

          for(String studentId:db.Courses.get(CourseID).students){
               System.out.println(db.Students.get(studentId).name);
          }

     }

     public void getAllCourses(){

          for (HashMap.Entry<String, Course> entry :db.Courses.entrySet()) {

               System.out.println(entry.getValue().toString());

          }
     }

     public void getStudentData(String studentId){
          System.out.println(db.Students.get(studentId).toString());
     }

     public void addAssignment(Assignment assignment){

          db.Assignmnets.put(assignment.getId(),assignment);
          db.Courses.get(assignment.getCourseId()).addAssignment(assignment.getId());
          System.out.println("Assignment: "+assignment.getId() +" for course: "+assignment.getCourseId()+" added successfully");

     }

     public void addCourse(String courseId,Course course){
          db.Courses.put(courseId,course);

     }

     public void submitStudentsAttendance(ArrayList<CourseAttendance> courseAttendance){
          for(CourseAttendance att:courseAttendance){

               try{
                    if(db.Courses.get(att.getCourseId()).students.contains(att.getStudentId())){
                         db.Courses.get(att.getCourseId()).addCourseAttendance(att);
                         System.out.println("Attendance for student: "+att.getStudentId()+" in course: "+att.getCourseId()+" submitted successfully");
                    }
                    else {
                    throw new Exception("Student with id : "+att.getStudentId()+" not enrolled in the course with id: "+ att.getCourseId() );
                    }
               } catch (Exception e){

                    System.out.println(e.getMessage());
               }
          }
     }



}

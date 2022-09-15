import java.util.LinkedList;
import java.util.Objects;

public class Student {

     String id;
     String name;
     String email;
     String mobileNumber;
     String age;
     String address;
     String gender;
     Database db;
     LinkedList<String> enrolledCourses;

     public Student(String id, String name, String email, String mobileNumber, String age, String address, String gender) {
          this.id = id;
          this.name = name;
          this.email = email;
          this.mobileNumber = mobileNumber;
          this.age = age;
          this.address = address;
          this.gender = gender;
          this.db=this.db.getInstance();
          this.enrolledCourses = new LinkedList<String>();
     }

     @Override
     public String toString() {
          return "Student{" +
                  "id='" + id + '\'' +
                  ", name='" + name + '\'' +
                  ", email='" + email + '\'' +
                  ", mobileNumber='" + mobileNumber + '\'' +
                  ", age='" + age + '\'' +
                  ", address='" + address + '\'' +
                  ", gender='" + gender + '\'' +
                  '}';
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Student student = (Student) o;
          return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(mobileNumber, student.mobileNumber) && Objects.equals(age, student.age) && Objects.equals(address, student.address) && Objects.equals(gender, student.gender);
     }

     @Override
     public int hashCode() {
          return Objects.hash(id, name, email, mobileNumber, age, address, gender);
     }

     public void addCourse(String course){
          enrolledCourses.add(course);

     }
     public void removeStudentfromcourses(){
          for(String courseid:enrolledCourses){
               db.Courses.get(courseid).students.remove(id);
          }
     }
     public void viewEnrolledCourses(){

          System.out.println("Student "+name+" enrolled in the following courses:");
          for(String course:enrolledCourses){
               System.out.println(db.Courses.get(course).toString());
          }
     }

     public void viewAssignments(String CourseID){

          db.Courses.get(CourseID).showAssignments();

     }

     public void submitAssignment(AssignmentSubmission assign){

          try
          {
               if(!enrolledCourses.contains(assign.getCourseId()) ){

                    throw new Exception("Student with id : "+assign.getStudentId()+" not enrolled in the course with id: "+ assign.getCourseId() );
               }
                    else if(! db.Courses.get(assign.getCourseId()).assignments.contains(assign.getAssignmentId())){

                    throw new Exception("Course with id : "+assign.getCourseId()+" doesn't have assignment with id: "+ assign.getAssignmentId() );

               }
               else {
                    db.Assignmnets.get(assign.getAssignmentId()).addAssignmentSubmission(assign);
                    System.out.println("Submitted successfully");

               }

          } catch (Exception e){

               System.out.println(e.getMessage());
          }

     }
}

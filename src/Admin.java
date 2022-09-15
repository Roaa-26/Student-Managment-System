import java.util.HashMap;

public class Admin {

    private String id;
    private String name;
    private String email;
    private String mobileNumber;
    Database db;

    public Admin() {
        this.db=this.db.getInstance();
    }

    public Admin(String id, String name, String email, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.db=this.db.getInstance();
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void addTeacher(Teacher teacher){
        db.Teachers.put(teacher.id,teacher);
        System.out.println("Teacher with id: "+teacher.id +" is added");

    }

    public void removeTeacher(String teacherId) {
        try
        {
        db.Teachers.remove(teacherId);
        System.out.println("Teacher with id: "+teacherId +" is removed");
        } catch (Exception e){

            System.out.println(e.getMessage());

        }

    }

    public void viewAllTeachers(){

        for (HashMap.Entry<String, Teacher> entry :db.Teachers.entrySet()) {

            System.out.println(entry.getValue().toString());

        }

    }

    public void viewTeacherDetails(String teacherId){

        try {
            System.out.println(db.Teachers.get(teacherId).toString());
        } catch (Exception e){
            System.out.println("No Teacher with id: "+teacherId);
        }

    }

    public void updateTeacherData(String teacherId,String newEmail,String newMobileNumber){

        try{
            db.Teachers.get(teacherId).email=newEmail;
            db.Teachers.get(teacherId).mobileNumber=newMobileNumber;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void addStudent(Student student){

        db.Students.put(student.id,student);
        System.out.println("Student with id: "+student.id +" is added");

    }

    public void removeStudent(String studentId){

        try{
            db.Students.get(studentId).removeStudentfromcourses();
            db.Students.remove(studentId);
            System.out.println("Student with id: "+studentId +" is removed");


        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void viewAllStudents(){

        for (HashMap.Entry<String, Student> entry :db.Students.entrySet()) {

            System.out.println(entry.getValue().toString());

        }
    }

    public void viewStudentDetails(String studentId){

        try{

        System.out.println(db.Students.get(studentId).toString());

        } catch (Exception e){
            System.out.println("No Student with id: "+studentId);        }

    }

    public void updateStudentData(String studentId,String newEmail,String newMobileNumber,String newAddress){

        try {
            db.Students.get(studentId).address=newAddress;
            db.Students.get(studentId).email=newEmail;
            db.Students.get(studentId).mobileNumber=newMobileNumber;
       } catch (Exception e){
           System.out.println(e.getMessage());
       }


    }

    void addCourse(Course course){
        db.Courses.put(course.id,course);
        System.out.println("Course with id: "+ course.id+" is added");

    }

    void enrollStudentInCourse(String courseId,String studentId){

        try {
            if(db.Courses.get(courseId)==null ){
                throw new Exception("No Course with Id: "+courseId);
            }
            if(db.Students.get(studentId)==null ){
                throw new Exception("No Student with Id: "+studentId);
            }
            db.Students.get(studentId).addCourse(courseId);
            db.Courses.get(courseId).addStudent(studentId);
            System.out.println("Student with id: "+studentId+" enrolled to course with id: "+courseId);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
//    void enrollTeacherInCourse(String courseId,String teacherId){
//        if(db.Teachers.get(teacherId)!=null & db.Teachers.get(courseId)!= null)
//        {
//            db.Teachers.get(teacherId).addCourse(courseId,db.Courses.get(courseId));
//        }
//    }
}

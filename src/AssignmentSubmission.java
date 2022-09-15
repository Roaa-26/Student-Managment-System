import java.util.Date;

public class AssignmentSubmission {

    private String assignmentId;
    private String studentId;
    private String courseId;
    private Date submissionDate = new Date();
    private String assignmentContentsubmitted;
    private float assignmentMarks = 0.0F;

    public AssignmentSubmission(String assignmentId, String studentId, String courseId, Date submissionDate, String assignmentContentsubmitted) {
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.submissionDate = submissionDate;
        this.assignmentContentsubmitted = assignmentContentsubmitted;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getAssignmentContentsubmitted() {
        return assignmentContentsubmitted;
    }

    public void setAssignmentContentsubmitted(String assignmentContentsubmitted) {
        this.assignmentContentsubmitted = assignmentContentsubmitted;
    }

    public float getAssignmentMarks() {
        return assignmentMarks;
    }

    public void setAssignmentMarks(float assignmentMarks) {
        this.assignmentMarks = assignmentMarks;
    }
}

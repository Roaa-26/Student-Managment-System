import java.util.Date;
import java.util.LinkedList;

public class Assignment {

    private String id;
    private String description;
    private String courseId;
    private Date dueDate;
    LinkedList<AssignmentSubmission> submittedAssignments;

    public Assignment(String id, String description, String courseId, Date dueDate) {
        this.id = id;
        this.description = description;
        this.courseId = courseId;
        this.dueDate = dueDate;
        this.submittedAssignments = new LinkedList<AssignmentSubmission>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void addAssignmentSubmission(AssignmentSubmission assign){

        submittedAssignments.add(assign);

    }
    @Override
    public String toString() {
        return "Assignment{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", courseId='" + courseId + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}

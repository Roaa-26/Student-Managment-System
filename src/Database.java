import java.util.HashMap;

class Database {

    private static Database db = null;
    HashMap<String,Teacher> Teachers;
    HashMap<String,Student> Students;
    HashMap<String,Course> Courses;
    HashMap<String, Assignment> Assignmnets;

    private Database() {

        Teachers = new HashMap<String,Teacher>();
        Students = new HashMap<String,Student>();
        Courses = new HashMap<String,Course>();
        Assignmnets = new HashMap<String,Assignment>();

    }

    public static Database getInstance()
    {
        if (db == null)
            db = new Database();

        return db;
    }
}

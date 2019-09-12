package demo;

/**
 * @author lz
 * @data 2019-09-11
 * @comment 描述
 */
public class Student {

    public Student() {
    }

    public Student(int flow_ID, int type, String ID_Card, String exam_Card, String student_Name, String location, int grade) {
        Flow_ID = flow_ID;
        Type = type;
        this.ID_Card = ID_Card;
        Exam_Card = exam_Card;
        Student_Name = student_Name;
        Location = location;
        Grade = grade;
    }

    private int Flow_ID;
    private int Type;
    private String ID_Card;
    private String Exam_Card;
    private String Student_Name;
    private String Location;
    private int Grade;

    public int getFlow_ID() {
        return Flow_ID;
    }

    public void setFlow_ID(int flow_ID) {
        Flow_ID = flow_ID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getID_Card() {
        return ID_Card;
    }

    public void setID_Card(String ID_Card) {
        this.ID_Card = ID_Card;
    }

    public String getExam_Card() {
        return Exam_Card;
    }

    public void setExam_Card(String exam_Card) {
        Exam_Card = exam_Card;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Flow_ID=" + Flow_ID +
                ", Type=" + Type +
                ", ID_Card='" + ID_Card + '\'' +
                ", Exam_Card='" + Exam_Card + '\'' +
                ", Student_Nmae='" + Student_Name + '\'' +
                ", Location='" + Location + '\'' +
                ", Grade=" + Grade +
                '}';
    }
}

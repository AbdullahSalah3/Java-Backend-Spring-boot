public class Student {
    private String studentsID ;
    private String  name;
    private double grade;

    Student(String studentsID , String  name , double grade){
        this.studentsID=studentsID;
        this.name=name;
        this.grade=grade;
    }

    public String getStudentsID() {
        return studentsID;
    }

    public void setStudentsID(String studentsID) {
        this.studentsID = studentsID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    public String getGradeStatus() {
        if (grade >= 90) {
            return "Excellent";
        } else if (grade >= 75) {
            return "Very Good";
        } else if (grade >= 60) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    public void print(){
        System.out.println("Student Id : "+ studentsID + " "+ "Student Name : "+ name + " " +  "Grade : "+ grade+" ");
    }
}

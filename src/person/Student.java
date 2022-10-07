package person;

public class Student <T extends Comparable<T>> implements Comparable<Student<T>> {
    private String id;
    private T grade;

    public Student(String id, T grade) {
        this.id = id;
        this.grade = grade;
    }

    public String getID() {
        return id;
    }

    public T getGrade() {
        return grade;
    }

    
    public void setID(String id) {
        this.id = id;
    }


    public void setGrade(T grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student<T> student) {
        return this.getGrade().compareTo(student.getGrade());
    }

    @Override
    public String toString() {
        return this.id + ": " + this.grade.toString();
    }
}

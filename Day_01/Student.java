public class Student {
    public int id;
    public String name;
    public int age;
    public int marks;
    public String grade;

    public Student(int id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | " + marks + " | " + grade;
    }
}


package student_manager_system;

/**
 * Student为实体对象，用来封装学生信息.
 */
public class Student {
    private String rank;//排位
    private String name;//姓名
    private int age;//年龄
    private String mark;//邮箱//分数
    private char gender;//性别

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMark() {

        return mark;
    }

    public void setMark(String mark) {

        this.mark = mark;
    }

    public Student() {

    }

    public Student(String name, char gender, int age, String mark, String rank) {
        this.rank = rank;
        this.gender = gender;
        this.age = age;
        this.mark = mark;
        this.name = name;
    }
}

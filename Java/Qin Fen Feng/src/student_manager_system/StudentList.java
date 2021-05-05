package student_manager_system;

/**
 * 内部用数组来管理一组Student对象，并提供相应的的添加、修改、删除和遍历的方法。
 * 供StudentView调用
 */
public class StudentList {
    private Student[] students;//保存学生数组
    private int total = 0;//记录学生对象数量

    /**
     * 初始化学生数组的构造器
     *
     * @param totalStudent:指定数组长度
     */
    public StudentList(int totalStudent) {
        students = new Student[totalStudent];
    }

    /**
     * 将指定学生添加到数组中
     *
     * @param student
     * @return true:添加成功;false:添加失败
     */
    public boolean addStudent(Student student) {
        if (total >= students.length) {
            return false;
        }
        students[total] = student;
        total++;
        return true;
    }

    /**
     * 修改指定索引位置上学生信息
     *
     * @param stu
     * @param index
     * @return true:修改成功;false:修改失败
     */
    public boolean replaceStudent(int index, Student stu) {
        if (index < 0 || index >= total) {
            return false;
        }
        students[index] = stu;
        return true;
    }

    /**
     * 删除指定位置上的学生
     *
     * @param index
     * @return true:删除成功;false:删除失败
     */
    public boolean deleteStudent(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            students[i] = students[i + 1];
        }
        //最后有数据的元素需要变"空"
        students[total - 1] = null;
        total--;
        return true;
    }

    /**
     * 获取所有学生信息
     *
     * @return 返回学生数组
     */
    public Student[] getAllStudents() {
        Student[] stus = new Student[total];
        for (int i = 0; i < total; i++) {
            stus[i] = students[i];
        }
        return stus;
    }

    /**
     * 获取指定位置上的学生
     *
     * @param index
     * @return 若找到元素则返回;否则返回null
     */
    public Student getStudent(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return students[index];
    }

    /**
     * 获取存储的学生数量
     *
     * @return
     */
    public int getTotal() {

        return total;
    }
}

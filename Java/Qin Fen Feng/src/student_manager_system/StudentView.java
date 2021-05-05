package student_manager_system;

import java.security.PublicKey;
import java.util.Scanner;

/**
 * 负责界面的显示和处理用户操作
 */
public class StudentView {
    private StudentList studentList = new StudentList(10);
    //测试:
//    public StudentView() {
//        Student student = new Student("张三", '男', 23, "5454", "666");
//        studentList.addStudent(student);
//    }

    /**
     * 显示学生信息管理界面的方法
     */
    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("------------欢迎来到学生管理系统，请选择操作------------\n");
            System.out.println("              1添加学生信息");
            System.out.println("              2修改学生信息");
            System.out.println("              3删除学生信息");
            System.out.println("              4学生列表");
            System.out.println("              5查找指定学生");
            System.out.print("              6退出系统\n");
            System.out.println("              请选择(1-6): ");
            char menu = StudentUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewStudent();
                    break;
                case '2':
                    modifyStudent();
                    break;
                case '3':
                    deleteStudent();
                    break;
                case '4':
                    listAllStudents();
                    break;
                case '5':
                    findStudent();
                    break;
                case '6':
//                    System.out.println("退出");
                    System.out.print("确认是否退出(Y/N): ");
                    char isExit = StudentUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
            }
        }

    }

    /**
     * 添加学生的操作
     */
    public void addNewStudent() {
        System.out.println("-------------------------添加学生---------------------");
        System.out.println("姓名: ");
        String name = StudentUtility.readString();

        System.out.println("性别: ");
        char gender = StudentUtility.readChar();

        System.out.println("年龄: ");
        int age = StudentUtility.readInt();

        System.out.println("分数: ");
        String mark = StudentUtility.readString();

        System.out.println("排位: ");
        String rank = StudentUtility.readString();

        //上述数据封装到对象中
        Student student = new Student(name, gender, age, mark, rank);
        boolean isSuccess = studentList.addStudent(student);
        if (isSuccess) {
            System.out.println("--------------------添加成功-------------------");
        } else {
            System.out.println("---------------------添加失败------------------");
        }
    }

    /**
     * 修改学生的操作
     */
    public void modifyStudent() {
        System.out.println("------------------------------修改学生---------------------------");
        Student stu;
        int number;
        for (; ; ) {
            System.out.print("请选择修改学生编号(-1退出): ");
            number = StudentUtility.readInt();
            if (number == -1) {
                return;
            }
            stu = studentList.getStudent(number - 1);
            if (stu == null) {
                System.out.println("无法找到指定学生!");
            } else {//找到指定学生
                break;//结束循环,防止方法体看着不简洁.
            }
        }
        //修改学生信息
        System.out.print("姓名(" + stu.getName() + "):");
        String name = StudentUtility.readString(stu.getName());

        System.out.print("性别(" + stu.getGender() + "):");
        char gender = StudentUtility.readChar(stu.getGender());

        System.out.print("年龄(" + stu.getAge() + "):");
        int age = StudentUtility.readInt(stu.getAge());

        System.out.print("分数(" + stu.getMark() + "):");
        String mark = StudentUtility.readString(stu.getMark());

        System.out.print("排位(" + stu.getRank() + "):");
        String rank = StudentUtility.readString(stu.getRank());

        Student newStudent = new Student(name, gender, age, mark, rank);
        boolean isRepalaced = studentList.replaceStudent(number - 1, newStudent);
        if (isRepalaced) {
            System.out.println("-------------------------修改完成----------------------------");
        } else {
            System.out.println("-------------------------修改失败----------------------------");
        }
    }

    /**
     * 删除学生的操作
     */

    public void deleteStudent() {
        System.out.println("-------------------删除学生--------------------");
        int number;
        for (; ; ) {
            System.out.println("请选择待删除学生编号(-1退出): ");
            number = StudentUtility.readInt();
            if (number == -1) {
                return;
            }

            Student student = studentList.getStudent(number - 1);
            if (student == null) {
                System.out.println("无法找到指定学生");
            } else {
                break;
            }
        }
        //找到指定学生.
        System.out.print("确认是否删除(Y/N): ");
        char isDalete = StudentUtility.readConfirmSelection();
        if (isDalete == 'Y') {
            boolean deleteSuccess = studentList.deleteStudent(number - 1);
            if (deleteSuccess) {
                System.out.println("---------------删除完成------------------");
            } else {
                System.out.println("---------------删除失败------------------");
            }
        } else {
            return;
        }
    }

    /**
     * 显示学生列表的操作
     */
    public void listAllStudents() {
        System.out.println("------------------学生列表-------------------------\n");
        int total = studentList.getTotal();
        if (total == 0) {
            System.out.println("没有学生记录!");
        } else {
            System.out.println("编号      姓名      性别      年龄      分数      排位");
            Student[] stus = studentList.getAllStudents();
            for (int i = 0; i < stus.length; i++) {
                Student stu = stus[i];
                System.out.println((i + 1) + "        " + stu.getName() +
                        "       " + stu.getGender() + "       " + stu.getAge() +
                        "       " + stu.getMark() + "      " + stu.getRank());
            }
        }

        System.out.println("------------------学生列表完成----------------------\n");
    }

    public void findStudent() {
        System.out.println("-------------------------查找学生---------------------");
        System.out.println("请选择输入查找的方式[7(姓名)或8(排位)]: ");
        char find = StudentUtility.readFindStudentSelection();
        Scanner scanner = new Scanner(System.in);
        String str;
        boolean isFlag = true;
        int total = studentList.getTotal();
        while (isFlag) {
            switch (find) {
                case '7':
                    System.out.println("请输入姓名: ");
                    str = scanner.nextLine();
                    int i;
                    for (i = 0; i < total; i++) {
                        if (str.equals(studentList.getStudent(i).getName())) {
                            break;
                        } else {
                            System.out.println("没有这个学生!");
                        }
                    }
                    System.out.println("姓名      性别      年龄      分数      排位");
                    System.out.println(studentList.getStudent(i).getName() + "        " +
                            studentList.getStudent(i).getGender() + "       " +
                            studentList.getStudent(i).getAge() + "       " +
                            studentList.getStudent(i).getMark() + "       " +
                            studentList.getStudent(i).getRank());
                    isFlag = false;
                    break;
                case '8':
                    System.out.println("请输入排位: ");
                    str = scanner.nextLine();
                    int j;
                    for (j = 0; j < total; j++) {
                        if (str.equals(studentList.getStudent(j).getRank())) {
                            break;
                        } else {
                            System.out.println("没有这个学生!");
                        }
                    }
                    System.out.println("姓名      性别      年龄      分数      排位");
                    System.out.println(studentList.getStudent(j).getName() + "        " +
                            studentList.getStudent(j).getGender() + "       " +
                            studentList.getStudent(j).getAge() + "       " +
                            studentList.getStudent(j).getMark() + "       " +
                            studentList.getStudent(j).getRank());
                    isFlag = false;
                    break;
                default:
                    System.out.println("未找到学生!");
                    isFlag = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        StudentView view = new StudentView();
        view.enterMainMenu();
    }
}

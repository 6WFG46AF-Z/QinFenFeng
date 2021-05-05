package student_manager_system;

import java.util.*;

/**
 * 将不同的功能封装为方法，供给其他类使用
 */
public class StudentUtility {
    private static Scanner scanner = new Scanner(System.in);

    /*
    用于菜单界面的选择。从键盘读入数据，如果用户输出“1-6”的任意字符，则方法返回.
     */
    public static char readMenuSelection() {
        char c;
        String str;
        for (; ; ) {
            str = scanner.nextLine();
            if (str.equals("")) {
                System.out.println("输入错误,请重新输入: ");
            } else {
                //输入选项
                c = str.charAt(0);
                if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6') {
                    System.out.println("选择错误,请重新输入: ");
                } else {
                    break;
                }
            }
        }
        return c;
    }

    /**
     * 性别
     * 从键盘读取一个字符,并作为方法的返回值
     *
     * @return c
     */

    public static char readChar() {
        return scanner.nextLine().charAt(0);
    }

    /**
     * 从键盘读取一个字符,并作为方法的返回值
     * 如果不输入字符直接回车defaultValue作为返回值
     *
     * @return
     */
    public static char readChar(char defaultValue) {
        String str = scanner.nextLine();
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * 年龄
     * 从键盘读入一个长度长度不超过2位的整数，并将其作为方法的返回值
     *
     * @param
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = scanner.nextLine();
            //出现异常:return后面出现语句
            try {   //try{可能出现异常的代码}catch(异常类名A e){如果出现了异常类型A的异常,则执行该代码}自己处理异常
                n = Integer.parseInt(str);//将String类型转为int型
                break;
                //NumberFormatException:String类型转Int类型异常
            } catch (NumberFormatException e) {
                System.out.println("数字有误,请重新输入: ");
            }
        }
        return n;
    }

    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = scanner.nextLine();
            if (str.equals("")) {
                return defaultValue;
            }
            try {   //try{可能出现异常的代码}catch(异常类名A e){如果出现了异常类型A的异常,则执行该代码}自己处理异常
                n = Integer.parseInt(str);//将String类型转为int型(lang包里面的方法)
                break;
                //NumberFormatException:String类型转Int类型异常
            } catch (NumberFormatException e) {
                System.out.println("数字有误,请重新输入: ");
            }
        }
        return n;
    }

    /**
     * 姓名
     * 从键盘读取一个长度不超过六位数的字符串,并将其作为方法的返回值
     */
    public static String readString() {
        String str = scanner.nextLine();
        ;
        return str;
    }

    /**
     * 从键盘读入姓名,如果不输入字符而直接回车,方法以defaultValue作为返回值.
     *
     * @param defaultValue
     * @return
     */
    public static String readString(String defaultValue) {
        String str = scanner.nextLine();
        return str.equals("") ? defaultValue : str;
    }

    /**
     * 用于确认是否删除或退出.
     * 该方法从键盘读入'Y'或'N',并将其作为返回值
     *
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = scanner.nextLine().toUpperCase();//toUpperCase():将小写字符转为大写
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("选择错误,请重新输入: ");
            }
        }
        return c;
    }

    /**
     * 用于读取"查找学生"时输入的字符
     *
     * @return c
     */
    public static char readFindStudentSelection() {
        char c;
        String str;
        for (; ; ) {
            str = scanner.nextLine();
            if (str.equals("")) {
                System.out.println("输入错误,请重新输入: ");
            } else {
                //输入选项
                c = str.charAt(0);
                if (c != '7' && c != '8') {
                    System.out.println("选择错误,请重新输入: ");
                } else {
                    break;
                }
            }
        }
        return c;
    }
}

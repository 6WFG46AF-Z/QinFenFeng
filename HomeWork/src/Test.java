import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2021-06-03-16:35
 */
public class Test {
    public static void main(String[] args) throws Exception{
        // 1.加载配置文件
        //  1.1 创建Properties对象
        Properties properties = new Properties();

        //  1.2 调用类加载器
        //   1.2.1 获取当前目录下的的配置文件
        ClassLoader classLoader = Test.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("properties.properties");
        properties.load(is);

        // 2. 获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 3. 加载该类进入内存
        Class clazz = Class.forName(className);

        // 4. 创建对象
        Object o = clazz.newInstance();

        // 5. 获取方法
        Method method = clazz.getMethod(methodName);

        // 6. 执行方法
        method.invoke(o);
    }
}

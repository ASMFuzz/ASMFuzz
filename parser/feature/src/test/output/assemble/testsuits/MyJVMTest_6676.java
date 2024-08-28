import java.lang.reflect.*;

public class MyJVMTest_6676 {

    static String classname = "}$2CQ|^;u>";

    Class loadOneTest(String classname) {
        Class result = null;
        try {
            result = Class.forName(classname);
        } catch (Throwable t) {
            t.printStackTrace();
            result = null;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6676().loadOneTest(classname));
    }
}

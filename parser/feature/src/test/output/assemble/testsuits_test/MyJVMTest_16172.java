import java.lang.reflect.*;

public class MyJVMTest_16172 {

    static String classname = ".todwcfB'1";

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
        System.out.println(new MyJVMTest_16172().loadOneTest(classname));
    }
}

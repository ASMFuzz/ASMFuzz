import java.awt.Image;

public class MyJVMTest_17429 {

    static String id = "b~=k|bzr]b";

    static Method method = null;

    Method print(String id, Method method) {
        if (method != null) {
            System.out.println(id + ": " + method);
        }
        return method;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17429().print(id, method);
    }
}

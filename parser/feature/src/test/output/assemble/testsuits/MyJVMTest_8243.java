import java.io.*;

public class MyJVMTest_8243 {

    static Object obj = 1367325957;

    Object replaceObject(Object obj) throws IOException {
        if (obj instanceof A)
            return null;
        else
            return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8243().replaceObject(obj));
    }
}

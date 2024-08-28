import java.io.*;

public class MyJVMTest_17819 {

    static Object obj = 1;

    Object replaceObject(Object obj) throws IOException {
        if (obj instanceof A)
            return null;
        else
            return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17819().replaceObject(obj));
    }
}

import java.io.*;

public class MyJVMTest_17469 {

    static Object obj = 2;

    Object replaceObject(Object obj) {
        if (obj instanceof PrintStream) {
            return new StdStream((PrintStream) obj);
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17469().replaceObject(obj));
    }
}

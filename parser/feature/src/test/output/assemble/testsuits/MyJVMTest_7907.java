import java.io.*;

public class MyJVMTest_7907 {

    static Object obj = 1522098211;

    Object replaceObject(Object obj) {
        if (obj instanceof PrintStream) {
            return new StdStream((PrintStream) obj);
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7907().replaceObject(obj));
    }
}

import java.io.*;

public class MyJVMTest_18079 {

    static Object obj = -1624998685;

    Object replaceObject(Object obj) throws IOException {
        if (obj instanceof PrintStream) {
            return new StdStream((PrintStream) obj);
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18079().replaceObject(obj));
    }
}

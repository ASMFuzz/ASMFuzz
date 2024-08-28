import java.io.*;

public class MyJVMTest_8489 {

    static Object obj = 5;

    Object replaceObject(Object obj) throws IOException {
        if (obj instanceof PrintStream) {
            return new StdStream((PrintStream) obj);
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8489().replaceObject(obj));
    }
}

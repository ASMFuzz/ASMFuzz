import java.io.*;

public class MyJVMTest_17686 {

    static Object obj = 7;

    static B b = new B();

    Object replaceObject(Object obj) throws IOException {
        if (obj instanceof A) {
            System.err.println("replaceObject(" + obj.toString() + ") with " + b.toString());
            return b;
        } else
            return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17686().replaceObject(obj));
    }
}

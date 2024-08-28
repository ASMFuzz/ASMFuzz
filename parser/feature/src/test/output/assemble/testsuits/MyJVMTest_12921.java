import java.io.*;

public class MyJVMTest_12921 {

    Object readResolve() throws ObjectStreamException {
        throw new Error("readResolve() called more than once");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12921().readResolve());
    }
}

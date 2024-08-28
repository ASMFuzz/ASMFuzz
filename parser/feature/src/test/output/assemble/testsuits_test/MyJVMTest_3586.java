import java.io.*;

public class MyJVMTest_3586 {

    Object readResolve() throws ObjectStreamException {
        throw new Error("readResolve() called more than once");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3586().readResolve());
    }
}

import java.io.*;

public class MyJVMTest_5927 {

    static Object obj = 0;

    static boolean writeReplaceCalled = false;

    Object writeReplace() throws ObjectStreamException {
        if (writeReplaceCalled) {
            throw new Error("multiple calls to writeReplace");
        }
        writeReplaceCalled = true;
        return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5927().writeReplace());
    }
}

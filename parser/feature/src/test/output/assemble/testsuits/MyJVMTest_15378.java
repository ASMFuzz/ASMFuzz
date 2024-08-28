import java.io.*;

public class MyJVMTest_15378 {

    static Object obj = -1259307666;

    static boolean writeReplaceCalled = false;

    Object writeReplace() throws ObjectStreamException {
        if (writeReplaceCalled) {
            throw new Error("multiple calls to writeReplace");
        }
        writeReplaceCalled = true;
        return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15378().writeReplace());
    }
}

import java.io.*;

public class MyJVMTest_7112 {

    static int writeReplaceCalled = 0;

    Object writeReplace() throws ObjectStreamException {
        writeReplaceCalled++;
        return new C();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7112().writeReplace());
    }
}

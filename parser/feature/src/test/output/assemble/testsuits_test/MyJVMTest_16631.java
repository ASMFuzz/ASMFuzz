import java.io.*;

public class MyJVMTest_16631 {

    static int writeReplaceCalled = 0;

    Object writeReplace() throws ObjectStreamException {
        writeReplaceCalled++;
        return new C();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16631().writeReplace());
    }
}

import java.io.*;

public class MyJVMTest_1243 {

    Object writeReplace() throws ObjectStreamException {
        return new C();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1243().writeReplace());
    }
}

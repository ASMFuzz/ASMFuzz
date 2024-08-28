import java.io.*;

public class MyJVMTest_8559 {

    Object writeReplace() throws ObjectStreamException {
        throw new Error("package-private writeReplace called");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8559().writeReplace());
    }
}

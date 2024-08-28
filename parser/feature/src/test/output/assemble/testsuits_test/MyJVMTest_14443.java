import java.io.*;

public class MyJVMTest_14443 {

    ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        throw new ClassNotFoundException("foobar");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14443().readClassDescriptor());
    }
}

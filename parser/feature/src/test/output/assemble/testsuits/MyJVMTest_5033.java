import java.io.*;

public class MyJVMTest_5033 {

    ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        throw new ClassNotFoundException("foobar");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5033().readClassDescriptor());
    }
}

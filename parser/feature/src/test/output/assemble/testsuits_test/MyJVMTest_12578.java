import java.io.*;
import java.util.*;

public class MyJVMTest_12578 {

    static LinkedList descs = null;

    ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        return (ObjectStreamClass) descs.removeFirst();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12578().readClassDescriptor());
    }
}

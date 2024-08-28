import java.io.*;
import java.util.*;

public class MyJVMTest_2350 {

    static LinkedList<ObjectStreamClass> descs = null;

    ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        return descs.removeFirst();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2350().readClassDescriptor());
    }
}

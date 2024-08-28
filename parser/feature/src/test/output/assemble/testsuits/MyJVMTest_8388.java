import java.io.*;
import java.util.*;

public class MyJVMTest_8388 {

    static LinkedList<ObjectStreamClass> descs = null;

    ObjectStreamClass readClassDescriptor() {
        return descs.removeFirst();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8388().readClassDescriptor());
    }
}

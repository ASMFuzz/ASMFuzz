import java.io.*;
import java.util.*;

public class MyJVMTest_5553 {

    static ObjectStreamClass desc = null;

    static LinkedList<ObjectStreamClass> descs = null;

    ObjectStreamClass writeClassDescriptor(ObjectStreamClass desc) throws IOException {
        descs.add(desc);
        return desc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5553().writeClassDescriptor(desc);
    }
}

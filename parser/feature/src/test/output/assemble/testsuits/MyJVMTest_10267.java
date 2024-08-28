import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_10267 {

    static Method m = null;

    static Class[] io = { Writer.class, BufferedWriter.class, FilterWriter.class, OutputStreamWriter.class, FileWriter.class };

    boolean test(Method m, boolean io) {
        Class[] ca = m.getExceptionTypes();
        boolean found = false;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i].equals(IOException.class)) {
                found = true;
                break;
            }
        }
        if (found && !io)
            throw new RuntimeException("Unexpected IOException");
        if (!found && io)
            throw new RuntimeException("Missing IOException");
        return found;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10267().test(m, io);
    }
}

import java.io.*;
import java.util.zip.*;

public class MyJVMTest_17747 {

    static Object o = 4;

    Object unreached(Object o) throws Exception {
        throw new Exception("Expected exception was not thrown");
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17747().unreached(o);
    }
}

import java.io.*;
import java.util.zip.*;

public class MyJVMTest_8174 {

    static Object o = 2094788975;

    Object unreached(Object o) throws Exception {
        throw new Exception("Expected exception was not thrown");
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8174().unreached(o);
    }
}

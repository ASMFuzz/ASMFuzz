import java.io.*;
import java.text.*;
import java.util.Locale;
import java.util.Arrays;

public class MyJVMTest_1574 {

    byte[] toByteArray() {
        String foo = "Hello";
        return foo.getBytes();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1574().toByteArray()));
    }
}

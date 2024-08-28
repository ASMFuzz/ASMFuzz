import java.io.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_13975 {

    MemoryUsage getMemoryUsage() {
        return new MemoryUsage(10, 20, 30, 40);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13975().getMemoryUsage());
    }
}

import java.io.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_12369 {

    String getName() {
        return "name";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12369().getName());
    }
}

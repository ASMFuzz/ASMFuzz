import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_13089 {

    static int passed = 0, failed = 0;

    boolean pass() {
        passed++;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13089().pass());
    }
}

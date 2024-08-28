import java.util.*;
import java.io.*;
import java.util.logging.*;

public class MyJVMTest_9660 {

    List<String> getDefaultLoggerNames() {
        List<String> expectedLoggerNames = new ArrayList<>();
        expectedLoggerNames.add("");
        expectedLoggerNames.add("global");
        return expectedLoggerNames;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9660().getDefaultLoggerNames());
    }
}

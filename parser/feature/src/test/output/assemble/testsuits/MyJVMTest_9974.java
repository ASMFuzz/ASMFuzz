import java.io.*;
import java.util.*;

public class MyJVMTest_9974 {

    void closeFile() {
        _pw.flush();
        _pw.close();
    }

    static PrintWriter _pw = null;

    void closeLog() {
        closeFile();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9974().closeLog();
    }
}

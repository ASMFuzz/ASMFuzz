import java.io.*;
import java.util.*;

public class MyJVMTest_10708 {

    static PrintWriter _pw = null;

    void closeFile() {
        _pw.flush();
        _pw.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10708().closeFile();
    }
}

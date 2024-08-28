import java.io.*;
import java.text.*;
import java.util.Locale;

public class MyJVMTest_9217 {

    static CollationKey target = null;

    int compareTo(CollationKey target) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9217().compareTo(target));
    }
}

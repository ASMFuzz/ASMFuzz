import java.io.*;

public class MyJVMTest_5073 {

    static String fName = "-geVfYZV#?";

    static int MAX_LENGTH = 256;

    String getNextName(String fName) {
        return (fName.length() < MAX_LENGTH / 2) ? fName + fName : fName + "A";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5073().getNextName(fName));
    }
}

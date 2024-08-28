import java.io.*;

public class MyJVMTest_14486 {

    static String fName = ">||*X5_ZVv";

    static int MAX_LENGTH = 256;

    String getNextName(String fName) {
        return (fName.length() < MAX_LENGTH / 2) ? fName + fName : fName + "A";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14486().getNextName(fName));
    }
}
